import kotlin.jvm.internal.Ref

fun main() {
    print(change(0, intArrayOf(1)))
}

private fun change(amount: Int, coins: IntArray): Int {
    coins.sort()

    val result = IntArray(amount + 1) { 0 }
    result[0] = 1

    coins.forEach { coin ->
        (1 until result.size).forEach loop@{
            val fetch = it - coin
            result[it] = result[it] + (result.getOrNull(fetch) ?: 0)
        }
    }

    return result.last()
}

private fun change2(amount: Int, coins: IntArray): Int {
    fun changeInternal(amount: Int, coins: IntArray, result: Ref.IntRef) {
        if (amount <= 0) {
            if (amount == 0) result.element++
            return
        }

        for (coin in coins) {
            if (coin > amount) break
            changeInternal(amount - coin, coins, result)
        }
    }

    coins.sort()
    val result = Ref.IntRef()
    changeInternal(amount, coins, result)
    return result.element
}