fun main() {
    println(
        minPathSum(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6)
            )
        )
    )
}

private fun minPathSum(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) return 0

    var result = grid.first()

    (1 until grid.size).forEach {
        val it = grid[it]

        val newResult = IntArray(grid.first().size) { Int.MAX_VALUE }

        it.forEachIndexed { column, it ->
            newResult[column] = if (column == 0) run {
                val lastResult = result[column]
                if (lastResult == Int.MAX_VALUE) it else lastResult + it
            } else minOf(newResult[column - 1] + it, run {
                val lastResult = result[column]
                if (lastResult == Int.MAX_VALUE) it else lastResult + it
            })
        }

        result = newResult
    }

    return result.last()
}