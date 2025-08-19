fun main() {
    println(zeroFilledSubarray(intArrayOf()))
}

private fun zeroFilledSubarray(nums: IntArray): Long {
    var currentZeroCount = 0L
    var result = 0L

    fun calculateResult(): Long {
        return (1L + currentZeroCount) * currentZeroCount / 2
    }

    nums.forEach {
        if (it == 0) {
            currentZeroCount++
        } else {
            result += calculateResult()
            currentZeroCount = 0
        }
    }

    result += calculateResult()
    return result
}