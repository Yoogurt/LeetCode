import kotlin.math.min

fun main(args: Array<String>) {
    println(minCostClimbingStairs(intArrayOf(10, 15, 20)))
}

private fun minCostClimbingStairs(cost: IntArray): Int {
    val result = IntArray(cost.size)

    result[0] = cost[0]
    result[1] = cost[1]

    for (index in 2 until result.size) {
        result[index] = min(result[index - 1], result[index - 2]) + cost[index]
    }

    return min(result[result.lastIndex], result[result.lastIndex - 1])
}