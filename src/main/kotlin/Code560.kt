fun main(args: Array<String>) {
    println(subarraySum(intArrayOf(1, 2, 1, 2), 3))
}

fun subarraySum(nums: IntArray, k: Int): Int {
    val sum = IntArray(nums.size + 1) { 0 }

    sum[1] = nums[0]

    nums.forEachIndexed { indexed, it ->
        sum[indexed + 1] = sum[indexed] + it
    }

    var result = 0

    (1 until sum.size).forEach { currentIndex ->
        val currentSum = sum[currentIndex]

        (0 until currentIndex).forEach {
            if (currentSum - sum[it] == k) {
                result++
            }
        }
    }

    return result
}