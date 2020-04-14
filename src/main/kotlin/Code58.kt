fun main(args: Array<String>) {
    println(lengthOfLastWord("world "))
}

private fun lengthOfLastWord(s: String): Int {
    if (s.isEmpty()) {
        return 0
    }

    var hasSpace = false
    var length = 0
    s.forEach {
        if (it == ' ') {
            hasSpace = true
        } else {
            if (hasSpace) {
                length = 0
                hasSpace = false
            }

            length++
        }
    }

    return length
}