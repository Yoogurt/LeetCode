import kotlin.math.max

fun main() {
    println(maxProfit(intArrayOf(1, 4, 8, 10, 15), 2))
//    println(maxProfit(intArrayOf(1, 4, 8, 10, 15), 2))
    println(maxProfit(intArrayOf(2, 1, 4, 4, 2, 3, 2, 5, 1, 2), 1))

}

private fun maxProfit(prices: IntArray, fee: Int): Int {
    if (prices.isEmpty()) {
        return 0
    }

    val maxProfit = IntArray(prices.size)

    (prices.lastIndex downTo 0).forEach { row ->
        (row until prices.size).forEach { column ->
            val temp = max(0, prices[column] - prices[row] - fee)
            maxProfit[row] = maxOf(maxProfit[row], temp + (maxProfit.getOrNull(column + 1) ?: 0))
        }
    }

    return maxProfit[0]
}