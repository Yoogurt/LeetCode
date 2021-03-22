fun main() {
    println(hammingWeight(-1))
}

private fun hammingWeight(n: Int): Int {
    var n = n
    var count = 0
    while (n != 0) {
        count++
        n = n and (n - 1)
    }
    return count
}