fun main() {
    println(coinChange(intArrayOf(1, 2, 5), 11))
    println(coinChange(intArrayOf(2), 3))
    println(coinChange(intArrayOf(1), 0))
    println(coinChange(intArrayOf(1), 1))
    println(coinChange(intArrayOf(1), 2))
}

private fun coinChange(coins: IntArray, amount: Int): Int {
    if(amount == 0){
        return 0
    }

    val result = IntArray(amount + 1) { -1 }

    result.forEachIndexed { indexed, it ->
        coins.forEach { coin ->
            if (indexed == coin) {
                result[indexed] = 1
                return@forEachIndexed
            }

            val requireCoins = (result.getOrNull(indexed - coin)?.takeIf { it > 0 } ?: return@forEach) + 1

            if (result[indexed] == -1) {
                result[indexed] = requireCoins
            } else {
                result[indexed] = minOf(
                    requireCoins,
                    result[indexed]
                )
            }
        }
    }

    return result.last()
}