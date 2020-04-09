fun main(args: Array<String>) {
    println(longestCommonPrefix(arrayOf("flower", "f", "flight")))
}

private fun longestCommonPrefix(strs: Array<String>): String {

    var sameIndex = 0

    while (true) {
        strs.forEachIndexed { indexed, it ->
            if (sameIndex >= it.length) {
                return strs.first().substring(0 until sameIndex)
            }

            if (indexed <= 0) {
                return@forEachIndexed
            } else {
                if (it[sameIndex] == strs[indexed - 1][sameIndex]) {
                    return@forEachIndexed
                } else {
                    return strs.first().substring(0 until sameIndex)
                }
            }
        }

        sameIndex++
    }
}