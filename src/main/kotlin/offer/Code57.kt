package offer

fun main(args: Array<String>) {
    findContinuousSequence(15).forEach {
        println(it.contentToString())
    }
}

private inline fun addResult(from: Int, to: Int, result: MutableList<IntArray>) {
    result += (from..to).toList().toIntArray()
}

fun findContinuousSequence(target: Int): Array<IntArray> {
    val target = target shl 1
    val result = mutableListOf<IntArray>()

    var left = 1
    var right = 2

    fun sumOf(left: Int, right: Int): Int {
        return (left + right) * (right - left + 1)
    }

    while (right in (left + 1) until target) {
        val sum = sumOf(left, right)
        when {
            sum == target -> {
                addResult(left, right, result)
                left++
                right++
            }

            sum < target -> {
                right++
            }

            else -> {
                left++
            }
        }
    }

    return result.toTypedArray()
}