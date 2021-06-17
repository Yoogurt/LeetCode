fun main() {
    println(solveNQueens(9))
}

private fun solveNQueens(n: Int): List<List<String>> {
    val result = mutableListOf<List<String>>()
    backTrack(0, n, IntArray(n) { -1 }, result)
    return result
}

private fun backTrack(row: Int, total: Int, placeInfo: IntArray, result: MutableList<List<String>>) {
    if (row == total) {
        result += placeInfo.map {
            buildString {
                repeat(it) {
                    append(".")
                }

                append("Q")

                repeat(total - it - 1) {
                    append(".")
                }
            }
        }
        return
    }

    repeat(total) {
        if (canPlace(row, it, placeInfo)) {
            placeInfo[row] = it
            backTrack(row + 1, total, placeInfo, result)
            placeInfo[row] = -1
        }
    }
}

private fun canPlace(row: Int, index: Int, info: IntArray): Boolean {
    return (0 until row).all {
        val placeIndex = info[it]
        placeIndex != -1 && placeIndex != index && index != placeIndex + (row - it) && index != placeIndex - (row - it)
    }
}