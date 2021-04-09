fun main() {
    println(subsets(intArrayOf(1,2,3)))
}

private fun subsets(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    subsets(nums, 0, mutableListOf(), result)
    return result
}

private fun subsets(nums: IntArray, current: Int, currentPath: MutableList<Int>, result: MutableList<List<Int>>) {
    if (current > nums.lastIndex) {
        result += ArrayList(currentPath)
        return
    }

    subsets(nums, current + 1, currentPath, result)
    currentPath += nums[current]
    subsets(nums, current + 1, currentPath, result)
    currentPath.removeAt(currentPath.lastIndex)
}