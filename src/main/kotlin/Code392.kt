fun main() {
    println(isSubsequence("abc", "ahbgdc"))
    println(isSubsequence("axc", "ahbgdc"))
}

private fun isSubsequence(s: String, t: String): Boolean {
    if (s.isEmpty()) {
        return true
    }

    var scanIndex = 0

    t.forEach {
        if (s[scanIndex] == it) {
            scanIndex++
        }

        if (scanIndex == s.length) {
            return true
        }
    }

    return scanIndex == s.length
}