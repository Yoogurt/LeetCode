fun main(args: Array<String>) {
    println(plusOne(intArrayOf(9,9)).contentToString())
}

fun plusOne(digits: IntArray): IntArray {
    val result = mutableListOf<Int>()
    var carry = 1

    for (index in (digits.lastIndex downTo 0)) {
        var data = digits[index] + carry

        carry = if (data > 9) {
            data -= 10
            1
        } else {
            0
        }

        result.add(0, data)
    }

    if (carry > 0) {
        result.add(0, 1)
    }

    return result.toIntArray()
}