fun main() {
    println(
        minCostII(
            arrayOf(
                intArrayOf(10, 15, 12, 14, 18, 5),
                intArrayOf(5, 12, 18, 13, 15, 8),
                intArrayOf(4, 7, 4, 2, 10, 18),
                intArrayOf(20, 9, 9, 19, 20, 5),
                intArrayOf(10, 15, 10, 15, 16, 20),
                intArrayOf(9, 6, 11, 10, 12, 11),
                intArrayOf(7, 10, 6, 12, 20, 8),
                intArrayOf(3, 4, 4, 18, 10, 2)
            )
        )
    )
}

private fun minCostII(costs: Array<IntArray>): Int {
    if (costs.isEmpty()) return 0

    var result = IntArray(costs.first().size) { costs.first()[it] }

    costs.forEachIndexed { indexed, it ->
        if (indexed == 0) return@forEachIndexed

        val newResult = IntArray(costs.first().size) { Int.MAX_VALUE }

        it.forEachIndexed { indexed, cost ->
            result.forEachIndexed { resultIndexed, lastCost ->
                if (resultIndexed == indexed) return@forEachIndexed
                newResult[indexed] = minOf(newResult[indexed], cost + lastCost)
            }
        }

        result = newResult
    }


    return result.min()!!
}