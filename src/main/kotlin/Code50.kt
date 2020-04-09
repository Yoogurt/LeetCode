import kotlin.math.abs

fun main(args: Array<String>) {
    println(myPow(2.0, 9))
}

private fun myPow(x: Double, n: Int): Double {
    val isNegative = n < 0

    var n = abs(n)
    var x = x
    var result = 1.0
    while (n > 0) {
        if (n and 1 == 1) {
            result *= x
        }
        x *= x
        n = n ushr 1
    }

    return if (isNegative) {
        1 / result
    } else {
        result
    }
}