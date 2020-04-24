import kotlin.math.max

fun main(args: Array<String>) {
    println(maxSubArray(intArrayOf( 1)))
}

private   fun maxSubArray(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0;
    }

    var maxSum = 0
    var result = Int.MIN_VALUE

    nums.forEach {
        maxSum += it
        result = max(maxSum, result)

        maxSum = max(0, maxSum)
    }

    return result
}