fun main(args: Array<String>) {
    println(firstUniqChar("loveleetcode"))
}

private fun firstUniqChar(s: String): Int {
    val result = linkedMapOf<Char, Int>()

    s.forEach {
        val appearTimes = result[it]

        if (appearTimes == null) {
            result[it] = 1
        } else {
            result[it] = appearTimes + 1
        }
    }

    result.forEach { entry ->
        if (entry.value == 1) {
            return s.indexOfFirst {
                it == entry.key
            }
        }
    }

    return -1
}