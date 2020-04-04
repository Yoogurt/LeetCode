import kotlin.math.min

fun main(args: Array<String>) {
    println(minDistance("horse", "ros"))
    println(minDistance("a", "ab"))
    println(minDistance("ab", "a"))
}

private fun minDistance(word1: String, word2: String): Int {
    val word1Length = word1.length
    val word2Length = word2.length
    if (word1Length * word2Length == 0) {
        return word1Length + word2Length
    }

    val result = Array(word1Length + 1) {
        Array(word2Length + 1) {
            0
        }
    }

    (1 until word2Length).forEach { indexed ->
        result[0][indexed] = result[0][indexed - 1] + 1
    }

    (1 until word1Length).forEach { indexed ->
        result[indexed][0] = result[indexed - 1][0] + 1
    }

    (1..word1Length).forEach { columnIndex ->
        (1..word2Length).forEach { rowIndex ->

            if (word1[columnIndex - 1] == word2[rowIndex - 1]) {
                result[columnIndex][rowIndex] = result[columnIndex - 1][rowIndex - 1] - 1
            } else {
                result[columnIndex][rowIndex] =
                    min(
                        min(result[columnIndex][rowIndex - 1], result[columnIndex - 1][rowIndex]),
                        result[columnIndex - 1][rowIndex - 1]
                    ) + 1
            }
        }
    }

    return result.last().last()
}