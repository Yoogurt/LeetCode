fun main() {
    println(minWindow("ADOBECODEBANC", "BB"))
    println(minWindow("a",
        "aa"))
}

private fun minWindow(s: String, t: String): String {
    if (s.isEmpty() || t.isEmpty()) {
        return ""
    }

    if (t.length == 1) return if (t in s) t else ""

    var startIndex = 0
    var endIndex = -1
    var result: String? = null

    val targetSet = t.toSet()
    val noContainer = targetSet.toMutableSet()
    val charCount = hashMapOf<Char, Int>()
    val requireCount = hashMapOf<Char, Int>()

    t.forEach {
        requireCount[it] = (requireCount[it] ?: 0) + 1
    }

    fun deq() {
        startIndex++

        while (startIndex < endIndex && s[startIndex] !in targetSet) {
            startIndex++
        }
    }

    fun grow() {
        endIndex++

        while (endIndex < s.length && s[endIndex] !in targetSet) {
            endIndex++
        }
    }

    fun findFirstStart() {
        while (startIndex < s.length && s[startIndex] !in targetSet) {
            startIndex++
        }
        endIndex = startIndex - 1
    }

    findFirstStart()

    while (startIndex < s.length && endIndex < s.length) {

        while (noContainer.isNotEmpty()) {
            grow()

            if (endIndex >= s.length) {
                return result.orEmpty()
            } else {
                val char = s[endIndex]
                charCount[char] = (charCount[char] ?: 0) + 1

                if ((charCount[char] ?: 0) == (requireCount[char] ?: 0)) {
                    noContainer.remove(char)
                }
            }
        }

        val currentSubString = s.substring(startIndex..endIndex)

        if (result == null || endIndex - startIndex + 1 < result.length) {
            result = currentSubString
        }

        val pendingRemove = s[startIndex]

        charCount[pendingRemove] = charCount[pendingRemove]!! - 1
        if ((charCount[pendingRemove] ?: 0) < (requireCount[pendingRemove] ?: 0)) {
            noContainer.add(pendingRemove)
        }

        deq()
    }

    return result.orEmpty()
}