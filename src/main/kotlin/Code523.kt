fun main() {
    print(checkSubarraySum(intArrayOf(6), 6))
    print(checkSubarraySum(intArrayOf(23, 2, 6, 4, 7), 6))
    print(checkSubarraySum(intArrayOf(23, 2, 6, 4, 7), 13))
}

private fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
    var result = mutableSetOf<Int>()

    nums.forEach { num ->
        if (result.isEmpty()) {
            result.add(num % k)
            return@forEach
        }

        val newResult = mutableSetOf<Int>()

        result.forEach {
            val dividedResult = (it + num) % k

            if (dividedResult == 0) return true
            newResult.add(dividedResult)
            newResult.add(num % k)
        }

        result = newResult
    }

    return false
}