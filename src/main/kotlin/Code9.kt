fun main(args: Array<String>) {
    println(isPalindrome(121))
}

private fun isPalindrome(x: Int): Boolean {
    val chars = x.toString().toCharArray()

    (0 until (chars.size ushr 1)).forEach {
        if (chars[it] != chars[chars.lastIndex - it]) {
            return false
        }
    }

    return true
}