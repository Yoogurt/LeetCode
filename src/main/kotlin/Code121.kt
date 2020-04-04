import kotlin.math.max

fun main(args: Array<String>) {
    println(maxProfit(intArrayOf(0, 7, 6, 4, 3, 1)))
}

private fun maxProfit(prices: IntArray): Int {

    var minMoney = Int.MAX_VALUE
    var maxProfit = 0

    prices.forEach {
        if (minMoney > it) {
            minMoney = it
        } else {
            maxProfit = max(it - minMoney, maxProfit)
        }
    }

    return maxProfit
}