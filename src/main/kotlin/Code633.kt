import kotlin.math.sqrt

fun main() {
    println(judgeSquareSum(2))
}

private fun judgeSquareSum(c: Int): Boolean {
    var start = 0
    var end = sqrt(c * 1.0).toInt()

    while (start <= end) {
        val value = start * start + end * end

        when (value) {
            c -> {
                return true
            }

            in 0..<c -> {
                start++
            }

            else -> {
                end--
            }
        }
    }

    return false
}