fun main() {

}

private fun longestCommonSubsequence(text1: String, text2: String): Int {
    if (text1.isNullOrEmpty() || text2.isNullOrEmpty()) {
        return 0
    }

    val result = Array(text1.length) { Array(text2.length) { 0 } }

    text1.forEachIndexed { column, c1 ->
        text2.forEachIndexed { row, c2 ->
            result[column][row] = if (c1 == c2) {
                (result.getOrNull(column)?.getOrNull(row) ?: 0) + 1
            } else {
                maxOf(
                    result.getOrNull(column - 1)?.getOrNull(row) ?: 0,
                    result.getOrNull(column)?.getOrNull(row - 1) ?: 0
                )
            }
        }
    }

    return result.last().last()
}