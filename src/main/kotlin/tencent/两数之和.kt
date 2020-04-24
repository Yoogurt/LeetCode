package main.kotlin.Tencent

fun main() {
    println(twoSum(intArrayOf(11, 2, 7, 15), 9).contentToString())
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val array = nums.mapIndexed { index, i ->
        i to index
    }

    val nums = array.sortedBy {
        it.first
    }

    var startIndex = 0
    var endIndex = nums.lastIndex

    while (startIndex < endIndex) {

        val result = nums[startIndex].first + nums[endIndex].first
        if (result == target) {
            return intArrayOf(nums[startIndex].second, nums[endIndex].second)
        }

        if (result > target) {
            endIndex--
        } else {
            startIndex++
        }
    }

    throw Exception()
}