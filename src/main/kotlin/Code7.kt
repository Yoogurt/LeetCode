import kotlin.math.abs

fun main(args: Array<String>) {
    print(reverse(1534236469))
}

private fun reverse(x: Int): Int {
    val isNegative = x < 0
    var x = abs(x)

    var ret = 0
    val overFlow: Int = 0x7fffffff / 10

    while (x > 0) {
        if (ret > overFlow) {
            return 0
        }

        ret = ret * 10 + x % 10
        x /= 10
    }

    return when {
        ret < 0 -> {
            0
        }
        isNegative -> {
            -ret
        }
        else -> {
            ret
        }
    }
}