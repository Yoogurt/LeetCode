import kotlin.jvm.internal.Ref

fun main() {
    println(
        uniquePathsIII(
            arrayOf(
                intArrayOf(1, 0, 0, 0),
                intArrayOf(0, 0, 0, 0),
                intArrayOf(0, 0, 2, -1),
            )
        )
    )

    println(
        uniquePathsIII(
            arrayOf(
                intArrayOf(1, 0, 0, -1),
                intArrayOf(0, 0, 0, -1),
                intArrayOf(0, 0, 2, -1),
            )
        )
    )
}

private fun uniquePathsIII(grid: Array<IntArray>): Int {
    var beginX = 0
    var beginY = 0

    var totalZero = 0
    grid.forEachIndexed { rowIndex, it ->
        it.forEachIndexed { columnIndex, it ->
            when (it) {
                1 -> {
                    beginX = columnIndex
                    beginY = rowIndex
                }

                0 -> {
                    totalZero++
                }
            }
        }
    }

    val result = Ref.IntRef()
    visitElements(grid, beginX, beginY, -1, totalZero, result)
    return result.element
}

private fun visitElements(
    currentPath: Array<IntArray>,
    currentX: Int,
    currentY: Int,
    zeroVisit: Int,
    totalZero: Int,
    result: Ref.IntRef
) {
    val currentPosition = currentPath.getOrNull(currentY)?.getOrNull(currentX)

    if (currentPosition == null || currentPosition == -1) {
        return
    }

    if (currentPosition == 2) {
        if (zeroVisit == totalZero) {
            result.element++
        }
        return
    }

    if (currentPosition == 0 || currentPosition == 1) {
        currentPath[currentY][currentX] = -1

        visitElements(currentPath, currentX + 1, currentY, zeroVisit + 1, totalZero, result)
        visitElements(currentPath, currentX - 1, currentY, zeroVisit + 1, totalZero, result)
        visitElements(currentPath, currentX, currentY + 1, zeroVisit + 1, totalZero, result)
        visitElements(currentPath, currentX, currentY - 1, zeroVisit + 1, totalZero, result)

        currentPath[currentY][currentX] = 0
    }
}