fun main() {
    println(sortVowels("lEetcOde"))
}

private fun sortVowels(s: String): String {
    val vowels = mutableListOf<Char>()
    val vowelsSet = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    s.toCharArray().forEach {
        if (it in vowelsSet) {
            vowels += it
        }
    }

    vowels.sort()

    val stringBuilder = StringBuilder()
    s.toCharArray().forEach {
        if (it in vowelsSet) {
            stringBuilder.append(vowels.removeAt(0))
        } else {
            stringBuilder.append(it)
        }
    }

    return stringBuilder.toString()
}