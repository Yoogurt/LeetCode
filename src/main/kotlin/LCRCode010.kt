fun main() {
    println(subarraySum(intArrayOf(1,2,3), 3))
}

private fun subarraySum(nums: IntArray, k: Int): Int {
    val prefixSum = IntArray(nums.size) { 0 }
    nums.foldIndexed(0) { indexed, acc, current ->
        val result = acc + current
        prefixSum[indexed] = result
        return@foldIndexed result
    }

    var result = 0

    for (index in 0 until nums.size) {
        val sum = prefixSum[index]
        if (sum == k) {
            result++
        }

        (0 until index).forEach {
            if (sum - prefixSum[it] == k) {
                result++
            }
        }
    }

    return result
}