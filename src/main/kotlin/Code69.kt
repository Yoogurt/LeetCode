fun main(args: Array<String>) {
    println(mySqrt(4))
}

private fun mySqrt(x: Int): Int {
    val x = x.toLong()

    var left = 0L
    var right = x

    loop@
    while (left < right) {
        val middle = (left + right + 1) ushr 1
        val middlePowOf2 = middle * middle

        when {
            middlePowOf2 == x -> {
                return middle.toInt()
            }
            middlePowOf2 > x -> {
                right = middle - 1
            }
            else -> {
                left = middle
            }
        }
    }

    return left.toInt()
}