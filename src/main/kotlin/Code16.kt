import kotlin.math.absoluteValue

fun main() {
    println(myPow(1.00000 ,-2147483648))
}

private fun myPow(x: Double, n: Int): Double {
    if (n == 0){
        return 1.0
    }

    val reverse = n < 0
    val n = n.toLong().absoluteValue

    return myPow2(x, n).let {
        if (reverse) {
            1 / it
        } else {
            it
        }
    }
}

private fun myPow2(x: Double, n: Long): Double {
    if (n == 1L) {
        return x
    }

    val result = myPow2(x, n shr 1)

    return result * result * (x.takeIf { n and 1L == 1L } ?: 1.0)
}
