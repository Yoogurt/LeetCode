fun main() {
    println(maxProfit(intArrayOf(7,1,5,3,6,4)))
    println(maxProfit(intArrayOf(7,6,4,3,1)))
}

private fun maxProfit(prices: IntArray): Int {
    if (prices.isEmpty()) return 0

    var result = 0
    var last = 0

    prices.forEachIndexed { indexed , it ->
        if(indexed == 0) return@forEachIndexed

        last += it - prices[indexed - 1]

        result = maxOf(result, last)
        last = maxOf(last, 0)
    }

    return result
}