fun main() {
    println(isPalindrome("ab_a"))
}

private fun isPalindrome(s: String): Boolean {
    if (s.isEmpty()) {
        return true
    }

    val startChar = s.indexOfFirst {
        it in 'A'..'Z' || it in 'a'..'z' || it in '0'..'9'
    }

    val lastChar = s.indexOfLast {
        it in 'A'..'Z' || it in 'a'..'z' || it in '0'..'9'
    }

    if (startChar < 0 || lastChar < 0){
        return true
    }

    if (s[startChar].equals(s[lastChar], ignoreCase = true)) {
        return isPalindrome(s.substring((startChar + 1).coerceAtMost(lastChar), lastChar))
    }

    return false
}