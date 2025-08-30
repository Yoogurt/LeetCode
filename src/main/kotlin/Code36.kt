fun main() {
    println(
        isValidSudoku(
            arrayOf(
                charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
                charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                charArrayOf('.', '9', '2', '.', '.', '.', '.', '6', '.'),
                charArrayOf('1', '.', '.', '.', '6', '.', '.', '.', '3'),
                charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
            )
        )
    )
}

private fun isValidSudoku(board: Array<CharArray>): Boolean {
    val h = IntArray(9) { 0 }
    var v = 0
    val p = Array(3) {
        IntArray(3) { 0 }
    }

    var rowIndex = 0
    var columnIndex = 0

    while (rowIndex < board.size) {

        v = 0
        columnIndex = 0
        while (columnIndex < board[0].size) {
            if (board[rowIndex][columnIndex] == '.') {
                columnIndex++
                continue
            }

            val value = 1 shl (board[rowIndex][columnIndex] - '0')
            if (value and h[columnIndex] != 0) {
                return false
            }
            h[columnIndex] = h[columnIndex] or value

            if (value and v != 0) {
                return false
            }
            v = v or value

            val pvIndex = rowIndex / 3
            val phIndex = columnIndex / 3
            if (value and p[pvIndex][phIndex] != 0) {
                return false
            }
            p[pvIndex][phIndex] = p[pvIndex][phIndex] or value

            columnIndex++
        }

        rowIndex++
    }

    return true
}