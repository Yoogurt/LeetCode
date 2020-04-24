import kotlin.jvm.internal.Ref

fun main(args: Array<String>) {
    println(reversePairs(intArrayOf(7, 5, 8, 6, 4)))
}

private fun reversePairs(nums: IntArray): Int {
    val result = Ref.IntRef()

    mergeSortInternal(nums, result)

    return result.element
}

private fun mergeSortInternal(nums: IntArray, result: Ref.IntRef) {
    if (nums.size < 2) {
        return
    }

    val middle = nums.size ushr 1

    val left = nums.copyOfRange(0, middle)
    val right = nums.copyOfRange(middle, nums.size)

    mergeSortInternal(left, result)
    mergeSortInternal(right, result)

    var leftIndex = 0
    var rightIndex = 0

    while (leftIndex < left.size && rightIndex < right.size) {
        nums[leftIndex + rightIndex] = if (left[leftIndex] > right[rightIndex]) {
            result.element += right.size - rightIndex
            left[leftIndex++]
        } else {
            right[rightIndex++]
        }
    }

    while (leftIndex < left.size) {
        nums[leftIndex + rightIndex] = left[leftIndex++]
    }

    while (rightIndex < right.size) {
        nums[leftIndex + rightIndex] = right[rightIndex++]
    }
}