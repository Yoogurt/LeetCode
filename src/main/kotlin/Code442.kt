fun main() {
    println(findDuplicates(intArrayOf(4,3,2,7,8,2,3,1)))
}

private fun findDuplicates(nums: IntArray): List<Int> {
    val result = mutableListOf<Int>()

    nums.forEachIndexed { indexed, i ->
        val i = if (i <= 0) i.inv() else i

        if (nums[i - 1] <= 0) {
            result += i
        }

        nums[i - 1] = nums[i - 1].inv()
    }

    return result
}