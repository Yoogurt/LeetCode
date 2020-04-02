import java.lang.Math.abs

fun main(args: Array<String>) {
    print(myAtoi("0-2147483800"))
}

private fun myAtoi(str: String): Int {
    var ret = 0
    var first = true
    var isNegative = false
    var hasOverFlow = false

    val positiveOverFlow = 0x7fffffff / 10

    fun finalProceed(overFlow: Boolean): Int {
        return if (overFlow) {
            if (isNegative) {
                Int.MIN_VALUE
            } else {
                Int.MAX_VALUE
            }
        } else {
            if (isNegative) {
                -ret
            } else {
                ret
            }
        }
    }

    str.forEach {
        if (first) {
            if (it == ' ') {
                return@forEach
            }
            first = false

            if (it == '-') {
                isNegative = true
                return@forEach
            } else if (it == '+') {
                return@forEach
            }
        }

        if (ret >= positiveOverFlow) {
            if (ret > positiveOverFlow) {
                return finalProceed(true)
            }

            if (hasOverFlow) {
                return finalProceed(true)
            }
            hasOverFlow = true
            if (!isNegative && (it - '0') > Int.MAX_VALUE % 10) {
                return finalProceed(true)
            } else if (isNegative && (it - '0') > abs(Int.MIN_VALUE % 10)) {
                return finalProceed(true)
            }
        }

        if (it < '0' || it > '9') {
            return finalProceed(false)
        }

        ret = ret * 10 + (it - '0')
    }

    return finalProceed(false)
}