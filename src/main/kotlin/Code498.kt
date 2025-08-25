fun main() {
    println(
        findDiagonalOrder(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
//                intArrayOf(7, 8),
            )
        ).contentToString()
    )
}

private fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
    if (mat.isEmpty()) {
        return intArrayOf()
    }
    if (mat[0].isEmpty()) {
        return intArrayOf()
    }
    val lastRowIndex = mat.lastIndex
    val lastColumnIndex = mat[0].lastIndex

    var step = -1
    val result = mutableListOf<Int>()

    var columnIndex = 0
    var rowIndex = 0

    while (rowIndex != lastRowIndex || columnIndex != lastColumnIndex) {
        result += mat[rowIndex][columnIndex]

        rowIndex += step
        columnIndex -= step

        var revertStep = false

        if (rowIndex < 0) {
            rowIndex = 0
            revertStep = true
        } else if (rowIndex > lastRowIndex) {
            rowIndex = lastRowIndex
            columnIndex += 2
            revertStep = true
        }

        if (columnIndex < 0) {
            columnIndex = 0
            if (revertStep) {
                columnIndex++
            }
            revertStep = true
        } else if (columnIndex > lastColumnIndex) {
            columnIndex = lastColumnIndex
            if (revertStep) {
                rowIndex ++
            } else {
                rowIndex += 2

            }
            revertStep = true
        }

        if (revertStep) {
            step = -step
        }
    }

    result += mat[rowIndex][columnIndex]

    return result.toIntArray()
}