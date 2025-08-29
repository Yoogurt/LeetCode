fun main() {
    println(digitOneInNumber(101))
}

private fun digitOneInNumber(num: Int): Int {

    var level = 1
    var high = num / 10
    var low = 0
    var cur = num % 10

    var result = 0

    while (high != 0 || cur != 0) {
        when (cur) {
            0 -> {
                result += high * level
            }

            1 -> {
                result += high * level + low + 1
            }

            else -> {
                result += (high + 1) * level
            }
        }

        low = low + cur * level
        level *= 10
        cur = high % 10
        high /= 10
    }

    return result
}