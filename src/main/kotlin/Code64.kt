import kotlin.math.min

fun main(args: Array<String>) {
    print(minPathSum(arrayOf(intArrayOf(1, 3, 1), intArrayOf(1, 5, 1), intArrayOf(4, 2, 1))))
}

private fun minPathSum(grid: Array<IntArray>): Int {
    val result = Array(grid.size) {
        Array(grid.first().size) { 0 }
    }

    result[0][0] = grid[0][0]

    for (columnIndex in (1 until grid.first().size)) {
        result[0][columnIndex] = result[0][columnIndex - 1] + grid[0][columnIndex]
    }

    for (rowIndex in (1 until grid.size)) {
        result[rowIndex][0] = result[rowIndex - 1][0] + grid[rowIndex][0]
    }

    for (columnIndex in (1 until grid.first().size)) {
        for (rowIndex in (1 until grid.size)) {
            result[rowIndex][columnIndex] =
                min(result[rowIndex - 1][columnIndex], result[rowIndex][columnIndex - 1]) + grid[rowIndex][columnIndex]
        }
    }

    return result.last().last()
}