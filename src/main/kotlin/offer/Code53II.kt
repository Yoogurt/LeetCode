package offer

fun main(args: Array<String>) {
    println(missingNumber(intArrayOf(1)))
}

private fun missingNumber(nums: IntArray): Int {
    var left = 0
    var right = nums.lastIndex

    while (left <= right) {
        val middle = (left + right) ushr 1
        if (nums[middle] == middle) {
            left = middle + 1
        } else {
            right = middle - 1
        }
    }

    return left
}