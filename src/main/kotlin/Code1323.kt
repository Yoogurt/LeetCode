private fun maximum69Number (num: Int): Int {
    val chars = num.toString().toCharArray()

    for (index in chars.indices) {
        if (chars[index] == '6') {
            chars[index] = '9'
            break
        }
    }

    return chars.joinToString("").toIntOrNull() ?: 0
}