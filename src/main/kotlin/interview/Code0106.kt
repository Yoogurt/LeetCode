package interview

fun main(args: Array<String>) {
    println(compressString("aaa"))
}

private fun compressString(s: String): String {

    var lastChar: Char? = null
    var lastCharLength = 0

    val result = StringBuilder()

    s.forEach {
        if (lastChar == it) {
            lastCharLength++
        } else {
            if (lastChar != null) {
                result.append(lastCharLength)
            }
            lastChar = it
            lastCharLength = 1
            result.append(it)

            if (result.length >= s.length) {
                return s
            }
        }
    }

    result.append(lastCharLength)

    return if (result.length >= s.length) {
        s
    } else {
        result.toString()
    }
}