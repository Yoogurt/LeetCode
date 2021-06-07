fun main() {
    println(findTargetSumWays(intArrayOf(0,0,0,0,0,0,0,0,1), 1))
}

private fun findTargetSumWays(nums: IntArray, target: Int): Int {
    return findTargetSumWays(nums, nums.lastIndex, target)
}

private fun findTargetSumWays(nums: IntArray, index: Int, target: Int): Int {
    if (index == 0) {
        return (if (nums[index] == target) 1 else 0) + (if (nums[index] == -target) 1 else 0)
    }

    return findTargetSumWays(nums, index - 1, target - nums[index]) +
            findTargetSumWays(nums, index - 1, target + nums[index])
}