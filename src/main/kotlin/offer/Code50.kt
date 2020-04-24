package offer

fun main(args: Array<String>) {
    println(firstUniqChar("abaccdeff"))
}

private fun firstUniqChar(s: String): Char {
    val allChars = mutableMapOf<Char, Int>()

    s.forEach {
        allChars[it] = (allChars[it] ?: 0) + 1
    }

    allChars.forEach {
        if (it.value == 1) {
            return it.key
        }
    }

    return ' '
}