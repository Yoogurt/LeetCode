fun main(args: Array<String>) {
    println(reverseWords("  hello world!  "))
}

private fun reverseWords(s: String): String {
    val strings = s.split(" ")

    return strings.toMutableList().also {
        it.removeAll { it.isEmpty() }
    }.reversed().joinToString(separator = " ")
}