import java.util.*

fun main() {
    println(maxProfit(2, intArrayOf(6,1,3,2,4,7)))
}

private fun maxProfit(k: Int, prices: IntArray): Int {
    val profit = IntArray(prices.size - 1) {
        prices[it + 1] - prices[it]
    }

    val queue = PriorityQueue<Int>()

    var resultSubSequenceSum = 0
    var max = 0

    profit.forEach {
        resultSubSequenceSum += it
        max = maxOf(max, resultSubSequenceSum)

        if (resultSubSequenceSum < 0) {
            if (max > 0) {
                queue.offer(max)
            }
            resultSubSequenceSum = 0
            max = 0
        }
    }

    if (max > 0) {
        queue.offer(max)
    }

    var result = 0

    repeat(k) {
        result += if (queue.isNotEmpty()) queue.poll() else 0
    }

    return result
}