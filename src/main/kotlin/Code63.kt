fun main(args: Array<String>) {
    println(uniquePathsWithObstacles(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0))))
}

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    if (obstacleGrid.isEmpty() || obstacleGrid.first().isEmpty()) {
        return 0
    }

    val result = Array(obstacleGrid.size) {
        Array(obstacleGrid.first().size) {
            0
        }
    }

    var horizontalHasBarrier = false
    val horizontal = result.first()

    horizontal.forEachIndexed { indexed, _ ->
        if (obstacleGrid[0][indexed] == 1) {
            horizontalHasBarrier = true
        }

        if (!horizontalHasBarrier) {
            horizontal[indexed] = 1
        }
    }


    var verticalHasBarrier = false

    result.forEachIndexed { indexed, _ ->
        if (obstacleGrid[indexed][0] == 1) {
            verticalHasBarrier = true
        }

        if (!verticalHasBarrier) {
            result[indexed][0] = 1
        }
    }

    (1 until result.size).forEach { verticalIndex ->
        (1 until result.first().size).forEach { horizontalIndex ->
            result[verticalIndex][horizontalIndex] = if (obstacleGrid[verticalIndex][horizontalIndex] == 1) {
                0
            } else {
                result[verticalIndex - 1][horizontalIndex] + result[verticalIndex][horizontalIndex - 1]
            }
        }
    }

    return result.last().last()
}