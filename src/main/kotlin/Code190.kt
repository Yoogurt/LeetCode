fun main() {
    val realValue = 0b0
    println(realValue)
    println(reverseBits(realValue))
}

// you need treat n as an unsigned value
private fun reverseBits(n: Int): Int {
    var n = n
    var result = 0
    repeat (32) {
        result = (result shl 1) or (n and 1)
        n = n ushr 1
    }

    return result
}