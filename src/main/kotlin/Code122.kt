fun main(args: Array<String>) {
    print(maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}

private fun maxProfit(prices: IntArray): Int {
    if (prices.size <= 1) {
        return 0
    }

    var totalProfit = 0
    var lastMinPrice = prices.first()

    for (index in 1 until prices.size) {

        val profit = prices[index] - lastMinPrice

        if (profit > 0) {
            totalProfit += profit
            lastMinPrice = prices[index]
        } else {
            lastMinPrice = prices[index]
        }
    }

    return totalProfit
}