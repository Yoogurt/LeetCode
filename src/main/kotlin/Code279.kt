fun main() {
    println(numSquares(1))
    println(numSquares(13))
}

private fun numSquares(n: Int): Int {
    val result = IntArray(n + 1) { Int.MAX_VALUE }

    var start = 0
    var powOf2 = 0

    fun incrementAndUpdatePowOf2() {
        start++
        powOf2 = start * start
    }

    result.forEachIndexed { index, i ->
        if (index > powOf2) {
            incrementAndUpdatePowOf2()
        }

        if (index == powOf2)
            result[index] = 1
        else {
            (1 until start).forEach {
                result[index] = minOf(result[index], result[index - it * it] + 1)
            }
        }
    }

    return result.last()
}