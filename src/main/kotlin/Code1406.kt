import kotlin.math.max

fun main(args: Array<String>) {
    stoneGameIII(intArrayOf(1, 2, 3, 7, 1, 1, 1))
}

fun stoneGameIII(stoneValue: IntArray): String {
    val result = IntArray(stoneValue.size) {
        Int.MIN_VALUE
    }

    var sum = 0
    result[0] = stoneValue[0]

    stoneValue.forEachIndexed { index, data ->

        (max(0, index - 3) until index).forEach {
            result[index] = max(sum - result[it] + data, result[index])
        }

        sum += data
    }

    print(result.contentToString())

    return ""
}