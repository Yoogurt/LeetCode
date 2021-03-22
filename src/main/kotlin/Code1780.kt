fun main() {
    println(listOf<Int>(1, 2, 3).subListSafe(4 downTo 0 step 2))

    println(checkPowersOfThree(12))
    println(checkPowersOfThree(21))
    println(checkPowersOfThree(91))
}

inline fun <T> List<T>.subListSafe(range: IntProgression): List<T> {
    val result = mutableListOf<T>()

    range.forEach {
        result.add(getOrNull(it) ?: return@forEach)
    }

    return result
}

private fun checkPowersOfThree(n: Int): Boolean {
    var n = n
    while (n > 0) {
        if (n % 3 == 2) {
            return false
        }
        n /= 3
    }

    return true
}