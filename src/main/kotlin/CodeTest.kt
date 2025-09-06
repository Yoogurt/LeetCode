import kotlin.math.min

fun main() {
    println(editDistance("abcd", "ba"))
}

private fun editDistance(left: String, right: String): Int {
    val result = Array(right.length) {
        IntArray(left.length) { 0 }
    }
    val leftChars = left.toCharArray()
    val rightChars = right.toCharArray()

    result.forEachIndexed { rowIndex, it ->
        it.forEachIndexed { columnIndex, _ ->
            val replace = result.getOrNull(rowIndex - 1)?.getOrNull(columnIndex - 1) ?: 0

            if (leftChars[columnIndex] == rightChars[rowIndex]) {
                result[rowIndex][columnIndex] = replace
            } else {
                val add = result.getOrNull(rowIndex - 1)?.getOrNull(columnIndex) ?: 1000000
                val del = result.getOrNull(rowIndex)?.getOrNull(columnIndex - 1) ?: 1000000
                result[rowIndex][columnIndex] = minOf(add + 1, del + 1, replace + 1)
            }
        }
    }

    return result.last().last()
}