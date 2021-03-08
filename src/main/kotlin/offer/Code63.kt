package offer

fun main() {
    println(maxProfit(intArrayOf(7)))
}

private fun maxProfit(prices: IntArray): Int {
    if (prices.isEmpty()) {
        return 0
    }
    var result = 0
    var temp = prices.first()

    (1 until prices.size).forEach {
        val profit = prices[it] - temp
        result = kotlin.math.max(prices[it] - temp, result)

        if (profit < 0) {
            temp = prices[it]
        }
    }

    return result
}