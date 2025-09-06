fun main() {
    println(makeTheIntegerZero(3, -2))
}

private fun countOfOne(value: Long): Int {
    var value = value
    var result = 0

    while (value != 0L) {
        value = value and (value - 1)
        result++
    }

    return result
}

private fun makeTheIntegerZero(num1: Int, num2: Int): Int {
    var result = 0
    var num1 = num1.toLong()
    val num2 = num2.toLong()

    while (true) {
        if (num1 < result) {
            return -1
        }
        if (countOfOne(num1) <= result) {
            return result
        }
        result++
        num1 -= num2
    }
}