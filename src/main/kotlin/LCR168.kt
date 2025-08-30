import kotlin.math.min

fun main() {
    println(nthUglyNumber(10))
}

private fun nthUglyNumber(n: Int): Int {
    val result = IntArray(n + 1) { 1 }

    var p2 = 1
    var p3 = 1
    var p5 = 1

    (2 until result.size).forEach {
        val p2Result = result[p2] * 2
        val p3Result = result[p3] * 3
        val p5Result = result[p5] * 5

        val minValue = minOf(p2Result, p3Result, p5Result)
        result[it] = minValue

        if (minValue == p2Result) p2++
        if (minValue == p3Result) p3++
        if (minValue == p5Result) p5++
    }


    return result.last()
}