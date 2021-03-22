fun main() {
    println(lengthOfLIS(intArrayOf(1, 2, 3, 4, 1, 2)))
}

private fun lengthOfLIS(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }

    var maxResult = 0
    val result = IntArray(nums.size) { 1 }

    nums.forEachIndexed { indexed, it ->
        (0 until indexed).forEach { scanIndex ->
            if (nums[scanIndex] < it) {
                result[indexed] = maxOf(result[indexed], result[scanIndex] + 1)
            }
        }

        maxResult = maxOf(maxResult, result[indexed])
    }

    return maxResult
}