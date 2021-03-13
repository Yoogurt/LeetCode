fun main() {
    println(multiply(1, 12))
    println(multiply(3,4))
    println(multiply(3,5))
    println(multiply(5,3))
}

private fun multiply(A: Int, B: Int): Int {
    if (A == 1) {
        return B
    }

    if (B == 1) {
        return A
    }

    val needAddA = B and 1 == 1
    val result = multiply(A, B ushr 1)

    return result + result + (A.takeIf { needAddA } ?: 0)
}