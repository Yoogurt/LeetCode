fun main() {
    println(maxFreqSum("successes"))
}

private fun maxFreqSum(s: String): Int {
    val result = mutableMapOf<Char, Int>()
    val result2 = mutableMapOf<Char, Int>()
    val vowels = hashSetOf('a', 'e', 'i', 'o', 'u')

    s.forEach {
        val result = if (it in vowels) {
                result2
            } else {
                result
            }

        result.compute(it) { _, value ->
            (value ?: 0) + 1
        }
    }

    return (result.maxByOrNull {
        it.value
    }?.value ?: 0) +  (result2.maxByOrNull {
        it.value
    }?.value ?: 0)
}