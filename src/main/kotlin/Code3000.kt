import kotlin.math.max

fun main() {
    println(
        areaOfMaxDiagonal(
            arrayOf(
                intArrayOf(2, 10),
                intArrayOf(8, 6),
//                intArrayOf(16, 63),
//                intArrayOf(33, 56)
            )
        )
    )
}

private fun areaOfMaxDiagonal(dimensions: Array<IntArray>): Int {
    var max = 0
    var maxArea = 0

    dimensions.forEach {
        val target = it[0] * it[0] + it[1] * it[1]

        if (target > max) {
            max = target
            maxArea = it[0] * it[1]
        } else if (target == max) {
            maxArea = max(it[0] * it[1], maxArea)
        }
    }

    return maxArea
}