fun main() {
//    println(rob(intArrayOf(2, 3, 2)))
//    println(rob(intArrayOf(1, 2, 3, 1)))
    println(rob(intArrayOf(1, 3, 1, 3, 100)))
//    println(rob(intArrayOf(1, 2)))
}

private fun rob(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }

    if (nums.size == 1) {
        return nums[0]
    }

    return maxOf(
        robInternal(nums.copyOfRange(0, nums.lastIndex)),
        robInternal(nums.copyOfRange(1, nums.size))
    )
}

private fun robInternal(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }

    if (nums.size == 1) {
        return nums[0]
    }

    var result1 = nums[0]
    var result2 = maxOf(nums[1], result1)

    var result = maxOf(result1, result2)

    (2 until nums.size).forEach {
        result = maxOf(result1 + nums[it], result2)
        result1 = result2
        result2 = result
    }

    return result
}