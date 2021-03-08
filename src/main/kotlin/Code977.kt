import kotlin.math.abs
import kotlin.math.absoluteValue

/**
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
示例 1：
输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]

示例 2：
输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]

提示：
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums 已按 非递减顺序 排序

进阶：
请你设计时间复杂度为 O(n) 的算法解决本问题
 */
fun main() {
    println(sortedSquares(intArrayOf(-4, -1, 0, 3, 10)).contentToString())
}

private fun sortedSquares(nums: IntArray): IntArray {
    val result = IntArray(nums.size)

    var pointer1 = 0
    var pointer2 = nums.lastIndex
    var putIndex = result.lastIndex

    while (pointer1 <= pointer2) {
        val pointer1Value = nums[pointer1].absoluteValue
        val pointer2Value = nums[pointer2].absoluteValue

        result[putIndex--] = if (pointer1Value > pointer2Value) {
            pointer1++
            pointer1Value * pointer1Value
        } else {
            pointer2--
            pointer2Value * pointer2Value
        }
    }

    return result
}