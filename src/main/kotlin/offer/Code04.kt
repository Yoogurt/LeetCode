package offer

fun main() {
    println(
        findNumberIn2DArray(
            arrayOf(
                intArrayOf(1, 4, 7, 11, 15),
                intArrayOf(2, 5, 8, 12, 19),
                intArrayOf(3, 6, 9, 16, 22),
                intArrayOf(10, 13, 14, 17, 24),
                intArrayOf(18, 21, 23, 26, 30)
            ), 31
        )
    )
}

private fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {
    var columnIndex = 0
    var rowIndex = matrix.lastIndex

    val columnLastIndex = matrix.firstOrNull()?.lastIndex ?: 0

    while (true) {
        if (columnIndex > columnLastIndex) {
            break
        }

        if (rowIndex < 0) {
            break
        }
        val value = matrix[rowIndex][columnIndex]

        when {
            value > target -> {
                rowIndex--
            }
            value < target -> {
                columnIndex++
            }
            else -> {
                return true
            }
        }
    }
    return false
}