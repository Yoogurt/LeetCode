fun main() {
    println(generateMatrix(1).contentToString())
}

private fun generateMatrix(n: Int): Array<IntArray> {
    val columnStepState = intArrayOf(1, 0, -1, 0)
    val rowStepState = intArrayOf(0, 1, 0, -1)

    var minColumn = 0
    var maxColumn = n - 1
    var minRow = 0
    var maxRow = n - 1

    var currentState = 0
    val destination = n * n

    val result = Array(n) {
        IntArray(n) { 0 }
    }

    var currentColumn = 0
    var currentRow = 0

    var currentCount = 1
    while (true) {
        result[currentRow][currentColumn] = currentCount

        currentRow += rowStepState[currentState]
        currentColumn += columnStepState[currentState]

        var directionChanged = false

        if (currentRow < minRow) {
            currentRow = minRow
            minColumn++
            currentState++
            directionChanged = true
        } else
            if (currentRow > maxRow) {
                currentRow = maxRow
                maxColumn--
                currentState++
                directionChanged = true
            } else
                if (currentColumn < minColumn) {
                    currentColumn = minColumn
                    maxRow--
                    currentState++
                    directionChanged = true
                } else
                    if (currentColumn > maxColumn) {
                        currentColumn = maxColumn
                        minRow++
                        currentState++
                        directionChanged = true
                    }

        if (currentState > 3) {
            currentState = 0
        }
        if (directionChanged) {
            currentRow += rowStepState[currentState]
            currentColumn += columnStepState[currentState]
        }
        currentCount++
        if (currentCount > destination) {
            break
        }
    }

    return result
}