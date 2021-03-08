fun main() {
    println(encode(0))
    println(encode(1))
    println(encode(2))
    println(encode(3))
    println(encode(4))
    println(encode(5))
    println(encode(6))
    println(encode(7))
}

private fun encode(num: Int): String = buildString {
    val mask = 0xfffffffe.toInt()

    var num = num
    while (num > 0) {
        append((num and 1 or mask).inv())
        num = num ushr 1
    }
}.reversed().let {
    if (it.startsWith('0')) {
        it.substring(1)
    } else {
        it
    }
}