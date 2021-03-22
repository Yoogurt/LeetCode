package tencent

fun main(args: Array<String>) {
    val array1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val array2 = intArrayOf(2, 5, 6)

    merge(array1, 3, array2, 3)
    println(array1.contentToString())
}

private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var array1ReservedIndex = m - 1
    var array2ReservedIndex = n - 1
    var mergeIndex = nums1.lastIndex

    while (array1ReservedIndex >= 0 && array2ReservedIndex >= 0) {
        val dataToMerge = if (nums1[array1ReservedIndex] > nums2[array2ReservedIndex]) {
            nums1[array1ReservedIndex--]
        } else {
            nums2[array2ReservedIndex--]
        }

        nums1[mergeIndex--] = dataToMerge
    }

    while (array1ReservedIndex >= 0) {
        nums1[mergeIndex--] = nums1[array1ReservedIndex--]
    }

    while (array2ReservedIndex >= 0) {
        nums1[mergeIndex--] = nums2[array2ReservedIndex--]
    }
}
