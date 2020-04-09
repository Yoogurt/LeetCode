fun main(args: Array<String>) {
    val nums = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes(nums)
    println(nums.contentToString())
}

private fun moveZeroes(nums: IntArray) {

    var putIndex = 0
    nums.forEachIndexed { index, i ->
        if (i == 0) {
            return@forEachIndexed
        } else {
            if (putIndex != index) {
                nums[putIndex] = nums[index]
            }
            putIndex++
        }
    }

    while (putIndex < nums.size) {
        nums[putIndex++] = 0
    }
}