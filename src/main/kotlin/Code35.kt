fun main(args: Array<String>) {
    println(searchInsert(intArrayOf(1, 3, 5, 6), 4))
}

private fun searchInsert(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.lastIndex

    var middle: Int

    if (nums.last() < target) {
        return nums.size
    }

    while (left < right) {
        middle = (left + right) ushr 1

        if (nums[middle] >= target) {
            right = middle
        } else {
            left = middle + 1
        }
    }

    return left
}