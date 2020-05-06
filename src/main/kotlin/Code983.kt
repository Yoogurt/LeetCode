fun main(args: Array<String>) {
    println(mincostTickets(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31), intArrayOf(2, 7, 15)))
}

private fun mincostTickets(days: IntArray, costs: IntArray): Int {
    val result = IntArray(days.last())

    val oneDaysCost = costs[0]
    val sevenDaysCost = costs[1]
    val thirtyDayCost = costs[2]

    var scanIndex = 0

    fun minCostWithMoney(day: Int, expect: Int): Int {
        return if (day < 0) {
            expect
        } else {
            result[day] + expect
        }
    }

    result.forEachIndexed { index, _ ->
        if (days[scanIndex] == index + 1) {
            result[index] = minOf(
                minCostWithMoney(index - 1, oneDaysCost),
                minCostWithMoney(index - 7, sevenDaysCost),
                minCostWithMoney(index - 30, thirtyDayCost)
            )
            scanIndex++
        } else {
            result[index] = if (index > 0) {
                result[index - 1]
            } else {
                0
            }
        }
    }

    return result.last()
}