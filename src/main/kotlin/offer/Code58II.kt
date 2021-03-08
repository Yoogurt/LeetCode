package offer

fun main() {
    println(reverseLeftWords("abcdefg" , 7))
}

private fun reverseLeftWords(s: String, n: Int): String {
    val loop = n % s.length
    if (loop == 0){
        return s
    }

    val needMoveSubString = s.substring(0 until loop)
    val remainSubString = s.substring(loop)
    return "$remainSubString$needMoveSubString"
}