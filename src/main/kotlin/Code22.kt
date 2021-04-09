fun main(args: Array<String>) {
    println(generateParenthesis(3))
}

private fun generateParenthesis(n: Int): List<String> {
    val result = mutableListOf<String>()
    generateInternal("", 0, n, result)
    return result
}

private fun generateInternal(current: String, left: Int, leftLeft: Int, result: MutableList<String>) {
    if (leftLeft <= 0 && left <= 0) {
        result += current
        return
    }

    if (leftLeft > 0) {
        generateInternal("$current(", left + 1, leftLeft - 1, result)
        if (left > 0) {
            generateInternal("$current)", left - 1, leftLeft, result)
        }
    } else {
        generateInternal("$current)", left - 1, 0, result)
    }
}