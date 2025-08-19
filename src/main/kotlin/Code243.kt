import kotlin.math.min

fun main() {
    println(shortestDistance(arrayOf("practice", "makes", "perfect", "coding", "makes"), "practice", "coding"))
}

private fun shortestDistance(wordsDict: Array<String>, word1: String, word2: String): Int {
    var result = Int.MAX_VALUE

    wordsDict.forEachIndexed { indexed, string ->
        if (word1 != string) {
            return@forEachIndexed
        }

        var searchIndex = 1
        while (true) {
            var matched = false

            if (indexed - searchIndex >= 0) {
                val testString = wordsDict[indexed - searchIndex]

                if (testString == word2) {
                    result = min(result, searchIndex)
                    return@forEachIndexed
                }

                matched = true
            }

            if (indexed + searchIndex < wordsDict.size) {
                val testString = wordsDict[indexed + searchIndex]

                if (testString == word2) {
                    result = min(result, searchIndex)
                    return@forEachIndexed
                }

                matched = true
            }

            if (!matched) {
                return@forEachIndexed
            }
            searchIndex += 1
        }
    }

    return result
}