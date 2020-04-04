fun main(args: Array<String>) {
    println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
}

private fun maxSubArray(nums: IntArray): Int {

    var sum = 0
    var result = Int.MIN_VALUE

    nums.forEach {
        sum += it
        result = kotlin.math.max(result, sum)
        if (sum < 0) {
            sum = 0
        }
    }

    return result
}