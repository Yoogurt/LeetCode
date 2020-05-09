package interview

fun main(args: Array<String>) {
    println(waysToChange(10))
}

private fun waysToChange(n: Int): Int {
    val result = IntArray(n + 1) {
        0
    }

    result[0] = 1

    val coins = intArrayOf(1, 5, 10, 25)

    coins.forEach { coin ->
        (coin until result.size).forEach {
            result[it] = (result[it] + result[it - coin]) % 1000000007
        }
    }

    return result.last()
}