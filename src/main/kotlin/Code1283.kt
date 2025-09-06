fun main() {
    println(smallestDivisor(intArrayOf(1,2,3), 6))
}

private fun smallestDivisor(nums: IntArray, threshold: Int): Int {
    val sum = nums.sum()
    var result = sum / threshold + 1

    while (true) {
        val average = nums.fold(0) { acc, ret ->
            acc + ret / result + if (ret % result == 0) 0 else 1
        }

        if (average <= threshold) {
            return result
        }

        result++
    }
}