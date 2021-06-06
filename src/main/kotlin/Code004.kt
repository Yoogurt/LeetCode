fun main() {
    findMedianSortedArrays(intArrayOf(1, 3, 5, 7, 9), intArrayOf(2, 4, 6, 8, 10))
}

private fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    var firstStart = 0
    var firstEnd = nums1.lastIndex
    var secondStart = 0
    var secondEnd = nums2.lastIndex

    var firstMiddle = (firstStart + firstEnd) ushr 1
    var secondMiddle = (secondStart + secondEnd) ushr 1
    var firstMiddleValue = nums1[firstMiddle]
    var secondMiddleValue = nums2[secondMiddle]

    fun updateMiddle() {
        firstMiddle = (firstStart + firstEnd) ushr 1
        secondMiddle = (secondStart + secondEnd) ushr 1
        firstMiddleValue = nums1[firstMiddle]
        secondMiddleValue = nums2[secondMiddle]
    }

    var change: Boolean
    do {
        change = false

        if (firstStart < firstEnd) {
            if (firstMiddleValue < secondMiddleValue) {
                firstStart = firstMiddle + 1
            } else {
                firstEnd = firstMiddle - 1
            }
            change = true
        }

        if (secondStart < secondEnd) {
            if (firstMiddleValue < secondMiddleValue) {
                secondEnd = secondMiddle - 1
            } else {
                secondStart = secondMiddle + 1
            }
            change = true
        }

        updateMiddle()
    } while (change)

    assert(firstStart == firstEnd)
    assert(secondStart == secondEnd)

    return 0.0
}