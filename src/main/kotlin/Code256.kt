import kotlin.math.cosh

fun main() {
    println(minCost(arrayOf(intArrayOf(17,2,17) , intArrayOf(16,16,5) , intArrayOf(14,3,19))))
}

private fun minCost(costs: Array<IntArray>): Int {
    val startCost = costs.first()

    var first = startCost[0]
    var second = startCost[1]
    var third = startCost[2]

    (1 until costs.size).forEach {
        val cost = costs[it]

        val tempFirst = first
        val tempSecond = second
        val tempThird = third

        first = minOf(tempSecond , tempThird) + cost[0]
        second = minOf(tempFirst , tempThird) + cost[1]
        third = minOf(tempFirst , tempSecond) + cost[2]
    }

    return minOf(first, second, third)
}