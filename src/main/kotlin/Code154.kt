fun main() {
//    println(findMin(intArrayOf(1, 2, 3, 4, 5)))
    println(findMin(intArrayOf(2,2,2,0,2,2)))
//    println(findMin(intArrayOf(3, 4, 1, 2)))
}

private fun findMin(nums: IntArray): Int {
    return findMin(nums, 0 , nums.lastIndex)
}

private fun findMin(nums: IntArray, start: Int, end: Int): Int {
    var start = start
    var end = end

    var middle = 0

    fun updateMiddle() {
        middle = (start + end) ushr 1
    }

    if (nums[start] < nums[end]) {
        return nums[start]
    }
    val leftValue = nums[start]

    while (start < end) {
        updateMiddle()

        val middleValue = nums[middle]

        if (leftValue == middleValue) {
            return if (middle < end) {
                minOf(findMin(nums, start, middle), findMin(nums, middle + 1, end))
            } else {
                findMin(nums, start, middle)
            }
        } else if (leftValue > middleValue) {
            end = middle
        } else {
            start = middle + 1
        }
    }

    return nums[start]
}