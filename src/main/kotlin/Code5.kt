fun main(args: Array<String>) {
    println(longestPalindrome("abcda"))
}

private fun longestPalindrome(s: String): String {
    if (s.isEmpty()) {
        return s
    }

    val chars = s.toCharArray()

    var maxLengthStartIndex = -1
    var maxExtend = 0

    chars.forEachIndexed { indexed, it ->
        val centerExtend = (isPalindrome(chars, indexed, indexed) shl 1) - 1
        val betweenExtend = isPalindrome(chars, indexed, indexed + 1) shl 1

        if (centerExtend > maxExtend) {
            maxLengthStartIndex = indexed - ((centerExtend - 1) shr 1)
            maxExtend = centerExtend
        }

        if (betweenExtend > maxExtend) {
            maxLengthStartIndex = indexed - (betweenExtend shr 1) + 1
            maxExtend = betweenExtend
        }
    }

    return String(chars, maxLengthStartIndex, maxExtend)
}

private fun isPalindrome(data: CharArray, leftStart: Int, rightStart: Int): Int {
    var leftStart = leftStart
    var rightStart = rightStart

    var maxExtend = 0
    while (leftStart >= 0 && rightStart < data.size) {
        if (data[leftStart--] == data[rightStart++]) {
            maxExtend++
        } else {
            break
        }
    }

    return maxExtend
}