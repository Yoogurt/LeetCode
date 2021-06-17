fun main() {
    println(minSubArrayLen(11, intArrayOf(1, 2, 3, 4, 5)))
}

private fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var result = Int.MAX_VALUE

    var scanIndex = 0
    val sequence = mutableListOf<Int>()
    var sum = 0

    fun pop(): Boolean {
        var pop = false
        while (sum >= target && sequence.isNotEmpty()) {
            sum -= sequence.removeAt(0)

            if (sum >= target) result = minOf(result, sequence.size)
            pop = true
        }

        return pop
    }

    while (true) {
        while (scanIndex < nums.size && sum < target) {
            val add = nums[scanIndex++]
            sum += add
            sequence += add
        }

        if (sum >= target) {
            result = minOf(result, sequence.size)
        }

        if (!pop()) break
    }

    return result.takeIf { it != Int.MAX_VALUE } ?: 0
}