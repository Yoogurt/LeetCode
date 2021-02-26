import kotlin.math.min

fun main() {
    println(minimumTotal(listOf(listOf(-10))))
}

private fun minimumTotal(triangle: List<List<Int>>): Int {
    var currentDistance = mutableListOf<Int>()

    triangle.forEachIndexed { pathIndex, distances ->
        val currentLayerDistance = mutableListOf<Int>()

        distances.forEachIndexed { index, distance ->
            if (pathIndex == 0) {
                currentLayerDistance.add(distance)
            } else {
                currentLayerDistance.add(
                    min(currentDistance.getOrElse(index - 1) { Int.MAX_VALUE },
                        currentDistance.getOrElse(index) { Int.MAX_VALUE }) + distance
                )
            }
        }

        currentDistance = currentLayerDistance
    }

    return currentDistance.min() ?: 0
}