fun main() {
    println(flowerGame(1000000,1000000))
}

private fun flowerGame(n: Int, m: Int): Long {
    return (n ushr 1).toLong() * ((m + 1) ushr 1).toLong() + (m ushr 1).toLong() * ((n + 1) ushr 1).toLong()
}