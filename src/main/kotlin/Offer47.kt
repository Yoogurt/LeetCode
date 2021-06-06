fun main() {
    println(maxValue(arrayOf(intArrayOf(1, 3, 1))))
}

private fun maxValue(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) return 0

    val result = IntArray(grid.first().size) { 0 }

    grid.forEachIndexed { row, it ->
        it.forEachIndexed loop@{ column, it ->
            if (row == 0 && column == 0) {
                result[0] = it
                return@loop
            }

            result[column] = if (column == 0) {
                result[column] + it
            } else {
                maxOf(result[column - 1] + it, result[column] + it)
            }
        }
    }

    return result.last()
}