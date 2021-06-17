fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbb"))
    println(lengthOfLongestSubstring("pwwkew"))
    println(lengthOfLongestSubstring(""))
}

private fun lengthOfLongestSubstring(s: String): Int {
    var start = 0
    var end = 0

    val char = mutableSetOf<Char>()

    fun pop() {
        if (start >= end) return

        val toRemove = s[start++]
        char.remove(toRemove)

        while (start < end) {
            if (s[start] in char) break
        }
    }

    var result = 0

    while (true) {
        while (end < s.length && s[end] !in char) {
            char += s[end++]
            result = maxOf(result, end - start)
        }

        if (end >= s.length) break
        pop()
    }

    return result
}