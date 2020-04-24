package offer

fun main(args: Array<String>) {
    println(search2(intArrayOf(5, 7, 7, 8, 8, 8, 8, 10), 8))
}

private fun search(nums: IntArray, target: Int): Int {
    var result = 0

    var index = 0
    while (index < nums.size && nums[index] <= target) {
        if (nums[index++] == target) {
            result++
        }
    }

    return result
}

private fun search2(nums: IntArray, target: Int): Int {

    var left = 0
    var right = nums.lastIndex

    var middle = 0

    fun updateMiddle() {
        middle = (left + right) ushr 1
    }

    val lower: Int
    val larger: Int

    while (left <= right) {
        updateMiddle()
        if (nums[middle] >= target) {
            right = middle - 1
        } else {
            left = middle + 1
        }
    }

    lower = left

    left = 0
    right = nums.lastIndex

    while (left <= right) {
        updateMiddle()
        if (nums[middle] <= target) {
            left = middle + 1
        } else {
            right = middle - 1
        }
    }

    larger = left

    return larger - lower
}