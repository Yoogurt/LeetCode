fun main() {

}

private fun editDistance(source: String, des: String): Int {
    val result = Array(des.length) { IntArray(source.length) { Int.MAX_VALUE } }

    result.forEachIndexed { row, sourceArray ->
        sourceArray.forEachIndexed { column, current ->
            val currentCharIsSame = source[column] == des[row]

            val top = result.getOrNull(row - 1)?.get(column) ?: Int.MAX_VALUE
            val left = result[row].getOrNull(column - 1) ?: Int.MAX_VALUE
            val topLeft = result.getOrNull(row - 1)?.getOrNull(column - 1) ?: 0

            result[row][column] = minOf(top + 1, left + 1, topLeft + if (currentCharIsSame) 0 else 1)
        }
    }

    return result.last().last()
}