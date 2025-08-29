fun main() {
    println(validPalindrome("eeccccbebaeeabebccceea"))
}

private fun validPalindrome(s: String): Boolean {
    var allowMiss = true
    var allowTryingStartPosition = -1
    var allowTryingEndPosition = -1

    val chars = s.toCharArray()

    var startIndex = 0
    var endIndex = chars.lastIndex

    while (startIndex < endIndex) {
        val startChar = chars[startIndex]
        val endChar = chars[endIndex]

        if (startChar == endChar) {
            startIndex++
            endIndex--
            continue
        }

        if (!allowMiss) {
            if (allowTryingEndPosition != -1) {
                startIndex = allowTryingStartPosition
                endIndex = allowTryingEndPosition
                allowTryingEndPosition = -1
                allowTryingEndPosition = -1
                continue
            }

            return false
        }

        if (chars[startIndex + 1] == chars[endIndex]) {
            allowTryingStartPosition = startIndex
            allowTryingEndPosition = endIndex - 1
            startIndex += 2
            endIndex--
            allowMiss = false
        } else if (chars[startIndex] == chars[endIndex - 1]) {
            allowTryingStartPosition = startIndex + 1
            allowTryingEndPosition = endIndex
            startIndex++
            endIndex -= 2
            allowMiss = false
        } else {
            return false
        }
    }

    return true
}