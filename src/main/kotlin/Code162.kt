fun main() {
    println(findPeakElement(intArrayOf(1, 2)))
}

private fun findPeakElement(nums: IntArray): Int {
    if (nums.isEmpty()) return -1
    if (nums.size == 1) return 0

    var start = 0
    var end = nums.lastIndex

    fun IntArray.larger(from: Int, to: Int) =
        if (to in indices) if (from in indices) nums[from] > nums[to] else false else true

    while (start <= end) {
        val middle = (start + end) ushr 1

        if (nums.larger(middle, middle + 1) && nums.larger(middle, middle - 1)) {
            return middle
        }

        if (nums.larger(middle - 1, middle + 1))
            end = middle - 1 else start = middle + 1
    }

    return -1
}