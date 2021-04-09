fun main() {
    println(generateParenthesis(3))
}

private fun generateParenthesis(n: Int): List<String> {
    val result = mutableListOf<String>()
    generateParenthesis(n, 0, "", result)
    return result
}

private fun generateParenthesis(n: Int, left: Int, currentPath: String, result: MutableList<String>) {
    if (n == 0 && left == 0) {
        result += currentPath
        return
    }

    if (left > 0) {
        generateParenthesis(n, left - 1, "$currentPath)", result)
    }

    if (n > 0) {
        generateParenthesis(n - 1, left + 1, "$currentPath(", result)
    }
}