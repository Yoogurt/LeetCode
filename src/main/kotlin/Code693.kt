fun main() {
    println(hasAlternatingBits(0b100))
}

private fun hasAlternatingBits(n: Int): Boolean {
    val n = n xor (n ushr 1)
    return n and (n + 1) == 0
}