import kotlin.math.min

fun main() {
    println(
        countSquares(
            arrayOf(
                intArrayOf(0, 1, 0, 1),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(0, 1, 1, 1)
            )
        )
    )
    println(
        countSquares(
            arrayOf(
                intArrayOf(1, 0, 1),
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 0)
            )
        )
    )
}

private fun countSquares(matrix: Array<IntArray>): Int {
    if (matrix.isEmpty()) {
        return 0
    }
    if (matrix[0].isEmpty()) {
        return 0
    }
    var result = 0

    val h = Array(matrix.size) { Array(matrix[0].size) { 0 } }
    val v = Array(matrix.size) { Array(matrix[0].size) { 0 } }

    (0 until matrix.size).forEach { rowIndex ->
        (0 until matrix[0].size).forEach { columnIndex ->
            val value = matrix[rowIndex][columnIndex]

            if (value == 1) {
                val prevH = h.getOrNull(rowIndex)?.getOrNull(columnIndex - 1) ?: 0
                val prevV = v.getOrNull(rowIndex - 1)?.getOrNull(columnIndex) ?: 0

                h[rowIndex][columnIndex] = prevH + 1
                v[rowIndex][columnIndex] = prevV + 1

                for (index in 0..min(h[rowIndex][columnIndex], v[rowIndex][columnIndex])) {
                    if ((h.getOrNull(rowIndex - index)?.getOrNull(columnIndex) ?: 0) <= index) {
                        break
                    }
                    if ((v.getOrNull(rowIndex)?.getOrNull(columnIndex - index) ?: 0) <= index) {
                        break
                    }

                    result += 1
                }
            } else {
                h[rowIndex][columnIndex] = 0
                v[rowIndex][columnIndex] = 0
            }
        }
    }

    return result
}