fun main() {
    println(isUgly(7))
}

private fun isUgly(n: Int): Boolean {
    var n = n

    while (n > 1) {
        when {
            n and 1 == 0 -> {
                n = n ushr 1
            }
            n % 5 == 0 -> {
                n /= 5
            }
            n % 3 == 0 -> {
                n /= 3
            }
            else -> {
                return false
            }
        }
    }

    return n == 1
}