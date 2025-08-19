fun main() {
    println(reverseVowels("IceCreAm"))
}

private fun reverseVowels(s: String): String {
    var startIndex = 0
    var endIndex = s.length - 1

    val s = s.toCharArray()
    val vowels = hashSetOf<Char>('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

    while (startIndex < endIndex) {
        if (s[startIndex] !in vowels) {
            startIndex++
            continue
        }
        if (s[endIndex] !in vowels) {
            endIndex--
            continue
        }

        val temp = s[startIndex]
        s[startIndex] = s[endIndex]
        s[endIndex] = temp

        startIndex++
        endIndex--
    }

    return s.joinToString("")
}