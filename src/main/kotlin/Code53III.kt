fun main() {
    println(maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))
    println(maxSubArray(intArrayOf(1)))
    println(maxSubArray(intArrayOf(0)))
    println(maxSubArray(intArrayOf(-100000)))
}

private fun maxSubArray(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var result = Int.MIN_VALUE
    var current = 0
    nums.forEach {
        current += it

        result = maxOf(result, current)
        current = maxOf(current, 0)
    }

    return result
}