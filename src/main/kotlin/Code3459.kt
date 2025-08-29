import kotlin.math.max

fun main() {
//    println(
//        lenOfVDiagonal(
//            arrayOf(
//                intArrayOf(2, 2, 2, 2, 2),
//                intArrayOf(2, 0, 2, 2, 0),
//                intArrayOf(2, 0, 1, 1, 0),
//                intArrayOf(1, 0, 2, 2, 2),
//                intArrayOf(2, 0, 0, 2, 2)
//            )
//        )
//    )

//    println(
//        lenOfVDiagonal(
//            arrayOf(
//                intArrayOf(1, 2, 2, 2, 2),
//                intArrayOf(2, 2, 2, 2, 0),
//                intArrayOf(2, 0, 0, 0, 0),
//                intArrayOf(0, 0, 2, 2, 2),
//                intArrayOf(2, 0, 0, 2, 0)
//            )
//        )
//    )

    println(
        lenOfVDiagonal(
            arrayOf(intArrayOf(2,2),intArrayOf(0,1))
        )
    )

//    1,2,2,2,2],[2,2,2,2,0],[2,0,0,0,0],[0,0,2,2,2],[2,0,0,2,0
}

private fun lenOfVDiagonal(grid: Array<IntArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) {
        return 0
    }

    val leftTop = Array(grid.size) {
        IntArray(grid[0].size) {
            1
        }
    }

    val rightTop = Array(grid.size) {
        IntArray(grid[0].size) {
            1
        }
    }

    val leftBottom = Array(grid.size) {
        IntArray(grid[0].size) {
            1
        }
    }

    val rightBottom = Array(grid.size) {
        IntArray(grid[0].size) {
            1
        }
    }

    grid.forEachIndexed { rowIndex, it ->
        it.forEachIndexed { columnIndex, value ->
            val expectValue = if (value == 0 || value == 1) {
                2
            } else {
                0
            }

            if (grid.getOrNull(rowIndex - 1)?.getOrNull(columnIndex - 1) == expectValue) {
                leftTop[rowIndex][columnIndex] = leftTop[rowIndex - 1][columnIndex - 1] + 1
            }

            if (grid.getOrNull(rowIndex - 1)?.getOrNull(columnIndex + 1) == expectValue) {
                rightTop[rowIndex][columnIndex] = rightTop[rowIndex - 1][columnIndex + 1] + 1
            }
        }
    }

    (grid.lastIndex downTo 0).forEach { rowIndex ->
        grid[rowIndex].forEachIndexed { columnIndex, value ->
            val expectValue = if (value == 0 || value == 1) {
                2
            } else {
                0
            }

            if (grid.getOrNull(rowIndex + 1)?.getOrNull(columnIndex - 1) == expectValue) {
                leftBottom[rowIndex][columnIndex] = leftBottom[rowIndex + 1][columnIndex - 1] + 1
            }
            if (grid.getOrNull(rowIndex + 1)?.getOrNull(columnIndex + 1) == expectValue) {
                rightBottom[rowIndex][columnIndex] = rightBottom[rowIndex + 1][columnIndex + 1] + 1
            }
        }
    }

    var result = 1

    fun visitDirection(row: Int, column: Int, rowStep: Int, columnStep: Int, dp: Array<IntArray>) {
        var expectValue = 2

        var rowIndexVisit = row + rowStep
        var columnIndexVisit = column + columnStep
        var currentLength = 1
        while (true) {
            val needValue = grid.getOrNull(rowIndexVisit)?.getOrNull(columnIndexVisit) ?: break
            if (needValue != expectValue) {
                break
            }
            result = max(result, dp[rowIndexVisit][columnIndexVisit] + currentLength)

            rowIndexVisit += rowStep
            columnIndexVisit += columnStep
            currentLength++
            expectValue = 2 - expectValue
        }
    }

    grid.forEachIndexed { rowIndex, it ->
        it.forEachIndexed { columnIndex, value ->
            if (value == 1) {
                visitDirection(rowIndex, columnIndex, -1, -1, rightTop)
                visitDirection(rowIndex, columnIndex, 1, -1, leftTop)
                visitDirection(rowIndex, columnIndex, -1, 1, rightBottom)
                visitDirection(rowIndex, columnIndex, 1, 1, leftBottom)
            }
        }
    }


    return result
}