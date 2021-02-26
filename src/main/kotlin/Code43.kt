import kotlin.math.max

fun main() {
    println(multiply("123", "456"))
}

private fun multiply(num1: String, num2: String): String {
    val num1Chars = num1.toCharArray().also { it.reverse() }
    val num2Chars = num2.toCharArray().also { it.reverse() }

    val singleMultipleResult = arrayOfNulls<String>(num1Chars.size)

    num1Chars.forEachIndexed { indexed, number1 ->
        singleMultipleResult[indexed] = buildString {
            var extra = 0

            num2Chars.forEach { number2 ->
                val result = number1.myToInt() * number2.myToInt() + extra
                extra = result / 10
                append(result % 10)
            }

            if (extra > 0){
                append(extra)
            }
        }.reversed() + "0".repeat(indexed)
    }

    return singleMultipleResult.fold("0") { left, right ->
        plus(left, right!!)
    }.trimStart {
        it == '0'
    }.let {
        if (it.isEmpty()) {
            "0"
        } else {
            it
        }
    }
}

private fun plus(num1: String, num2: String): String {
    return buildString {
        val num1Chars = num1.toCharArray().also { it.reverse() }
        val num2Chars = num2.toCharArray().also { it.reverse() }

        var index = 0
        var extra = 0

        while (index < max(num1Chars.size, num2Chars.size)) {

            val result =
                (num1Chars.getOrNull(index)?.myToInt() ?: 0) + (num2Chars.getOrNull(index)?.myToInt() ?: 0) + extra
            append(result % 10)
            extra = result / 10

            index++
        }

        if (extra > 0) {
            append(extra)
        }
    }.reversed()
}

private inline fun Char.myToInt(): Int = this - '0'