import kotlin.math.absoluteValue

fun main() {
    println(getNoZeroIntegers(5320000).contentToString())
}

private fun getNoZeroIntegers(n: Int): IntArray {
    var current = n
    var base = 1

    val digits = mutableListOf<Int>()
    while (current > 0) {
        digits.add(current % 10)
        current /= 10
    }

    var sub = 0
    var result = 0
    var basement = 1
    while (digits.isNotEmpty()) {
        val value = if (digits.size == 1 && sub == 1) {
            digits[0] - sub
        } else {
            digits[0] - sub - base
        }

        if (value > 0) {
            sub = 0
            base = 1
            result = result + value * basement
            basement *= 10
            digits.removeAt(0)
        } else if (value < 0) {
            sub = 1
            base = 1
            result = result + (10 + value) * basement
            basement *= 10
            digits.removeAt(0)
        } else {
            if (digits.size == 1) {
                break
            }
            base++
        }
    }

    return intArrayOf(result, n - result)
}