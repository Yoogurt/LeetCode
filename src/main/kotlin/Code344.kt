fun main(args: Array<String>) {
    val ret = "Let's take LeetCode contest"
    println(reverseWords(ret))
}

fun reverseWords(s: String): String {
    val ret = s.split(" ")

    return ret.map {
        val charArray = it.toCharArray()
        reverseString(charArray)
        String(charArray)
    }.joinToString(separator = " ")
}

fun reverseString(s: CharArray) {
    for (index in 0 until (s.size ushr 1)) {
        val tmp = s[index]
        s[index] = s[s.lastIndex - index]
        s[s.lastIndex - index] = tmp
    }
}