fun main() {
    println(maxSubArray(intArrayOf(-2, 1)))
}

private fun maxSubArray(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var result = 0
    var sum = 0

    nums.forEach {
        sum += it
        result = maxOf(result, sum)
        sum = maxOf(sum, 0)
    }

    return result
}