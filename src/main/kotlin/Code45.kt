import kotlin.math.min

fun main(args: Array<String>) {
    println(jump2(intArrayOf(2, 3, 1, 1, 4)))
}

private fun jump(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }

    val result = IntArray(nums.size) { Int.MAX_VALUE }
    result[0] = 0

    nums.forEachIndexed { currentIndex, _ ->
        for (scanIndex in 0 until currentIndex) {
            if (currentIndex - scanIndex - nums[scanIndex] <= 0) {
                result[currentIndex] = min(result[currentIndex], result[scanIndex] + 1)
            }
        }
    }

    return result.last()
}

private fun jump2(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }

    val result = IntArray(nums.size) { Int.MAX_VALUE }
    result[0] = 0

    nums.forEachIndexed { currentIndex, count ->
        repeat(count) {
            val arriveIndex = currentIndex + it + 1

            if (arriveIndex >= nums.size) {
                return@forEachIndexed
            }

            result[arriveIndex] = min(result[arriveIndex], result[currentIndex] + 1)
        }
    }

    return result.last()
}
