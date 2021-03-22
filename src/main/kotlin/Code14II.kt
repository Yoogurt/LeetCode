fun main() {
    println(cuttingRope(120))
}

private fun cuttingRope(n: Int): Int {
    when {
        n <= 0 -> return 0
        n == 1 -> return 1
        n == 2 -> return 1
        n == 3 -> return 2
    }

    val result = LongArray(n + 1) { 1 }
    result[1] = 1
    result[2] = 2
    result[3] = 3

    (1..n).forEach { scanIndex ->
        (1 until scanIndex).forEach {
            val previous = scanIndex - it
            result[scanIndex] = maxOf(result[scanIndex], (result[previous] * it)) % 1000000007
        }
    }

    return result.last().toInt()
}