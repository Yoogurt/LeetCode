fun main() {
    println(convertToTitle(1))
}

private fun convertToTitle(columnNumber: Int): String {
    return buildString {
        var current = columnNumber
        val start = 'A'.toInt()

        while (current > 0) {
            append((start + ((current - 1) % 26)).toChar())
            current = (current - 1) / 26
        }
    }.reversed()
}