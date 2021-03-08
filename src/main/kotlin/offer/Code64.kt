package offer

fun main() {
    println(sumNums(100))
}

private fun sumNums(n: Int): Int {
    n.takeIf { n > 0 } ?: return 0
    return n + sumNums(n - 1)
}