fun main() {
    println(
        sortMatrix(
            arrayOf(
                intArrayOf(1, 2, 3, 77),
                intArrayOf(4, 5, 6, 88),
                intArrayOf(7, 8, 9, 99),
                intArrayOf(10, 11, 12, 100),
            )
        ).contentToString()
    )
}

private fun sortMatrix(grid: Array<IntArray>): Array<IntArray> {
    if (grid.isEmpty()) {
        return grid
    }

    val sort = mutableListOf<Int>()

    (0 until grid.size).forEach {
        var columnIndex = 0
        var rowIndex = grid.lastIndex - it

        if (it == 0) {
            return@forEach
        }

        sort.clear()
        repeat(it + 1) {
            sort += grid[rowIndex][columnIndex]
            rowIndex++
            columnIndex++
        }
        sort.sort()
        sort.reverse()

        columnIndex = 0
        rowIndex = grid.lastIndex - it
        repeat(it + 1) {
            grid[rowIndex][columnIndex] = sort[it]
            rowIndex++
            columnIndex++
        }
    }

    (1 until grid.lastIndex).forEach {
        var columnIndex = it
        var rowIndex = 0

        sort.clear()
        repeat(grid.size - it) {
            sort += grid[rowIndex][columnIndex]
            rowIndex++
            columnIndex++
        }

        sort.sort()

        columnIndex = it
        rowIndex = 0
        repeat(sort.size) {
            grid[rowIndex][columnIndex] = sort[it]
            rowIndex++
            columnIndex++
        }
    }

    return grid
}