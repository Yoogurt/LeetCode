fun main() {
    print(longestPalindrome("aacabdkacaa"))
}

private fun longestPalindrome(s: String): String {
    if (s.isEmpty()) return ""

    var result = IntArray(s.length) { 0 }
    var maxIndexStart = -1
    var maxLength = 0

    val sReversed = s.reversed()

    sReversed.forEachIndexed { row, reversed ->
        val newResult = IntArray(s.length) { 0 }
        s.forEachIndexed { column, raw ->
            if (raw == reversed) {
                val lastEquals = (result.getOrNull(column - 1) ?: 0) + 1
                newResult[column] = lastEquals

                if (lastEquals > maxLength) {
                    maxLength = lastEquals
                    maxIndexStart = column + 1 - lastEquals
                }
            } else {
                newResult[column] = 0
            }
        }

        result = newResult
    }

    return if (maxIndexStart == -1) "" else s.substring(maxIndexStart until maxIndexStart + maxLength)
}