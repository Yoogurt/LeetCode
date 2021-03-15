fun main() {
    println(spiralOrder(arrayOf(
        intArrayOf(1,7),
        intArrayOf(3,9)
    )))
    println(spiralOrder(arrayOf(
        intArrayOf(1),
        intArrayOf(3)
    )))
    println(spiralOrder(arrayOf(
        intArrayOf(1,7)
    )))
    println(spiralOrder(arrayOf(
        intArrayOf(1,7,3),
        intArrayOf(3,9,6)
    )))
}

private fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val height = matrix.size
    if (height <= 0) {
        return listOf()
    }

    val width = matrix.first().size
    if (width <= 0) {
        return listOf()
    }

    val result = mutableListOf<Int>()
    repeat(minOf(height, width)) {
        result += visit(matrix, width, height, it)
    }
    return result
}


private fun visit(matrix: Array<IntArray>, width: Int, height: Int, padding: Int): List<Int> {
    var horizontalIndex = padding
    var verticalIndex = padding

    val rightBoundIndex = width - padding
    val bottomBoundIndex = height - padding

    if (rightBoundIndex - padding <= 0 || bottomBoundIndex - padding <= 0){
        return emptyList()
    }

    val result = mutableListOf<Int>()

    while (horizontalIndex < rightBoundIndex) {
        result += matrix[verticalIndex][horizontalIndex++]
    }

    horizontalIndex--
    verticalIndex++

    if (verticalIndex >= bottomBoundIndex){
        return result
    }

    while (verticalIndex < bottomBoundIndex) {
        result += matrix[verticalIndex++][horizontalIndex]
    }

    verticalIndex--
    horizontalIndex--

    if (horizontalIndex < padding){
        return result
    }

    while (horizontalIndex >= padding) {
        result += matrix[verticalIndex][horizontalIndex--]
    }

    horizontalIndex++
    verticalIndex--

    if (verticalIndex <= padding){
        return result
    }

    while (verticalIndex > padding) {
        result += matrix[verticalIndex--][horizontalIndex]
    }

    return result
}
