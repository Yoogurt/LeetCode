import kotlin.math.max

fun main() {
    println(maximumProduct(intArrayOf(-1,-2,-3)))
}

private fun maximumProduct(nums: IntArray): Int {
    var result = Int.MIN_VALUE
    nums.sort()

    var startIndex = 0
    var endIndex = nums.lastIndex
    var middle = (startIndex + endIndex) ushr 1

    while (startIndex < endIndex) {
        middle = (startIndex + endIndex) ushr 1

        if (nums[middle] > 0) {
            endIndex--
        } else if (nums[middle] < 0) {
            startIndex++
        } else {
            break
        }
    }

    result = max(result, nums[0] * nums[1] * nums.last())
    result = max(result, nums[0] * nums[1] * nums[2])
    result = max(result, nums[nums.lastIndex - 2] * nums[nums.lastIndex - 1] * nums[nums.lastIndex])

    if (middle - 1 > 0 && middle + 1 < nums.size) {
        result = max(result, nums[middle - 1] * nums[middle] * nums[middle + 1])
    }
    return result
}