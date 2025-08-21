fun main() {
    println(
        numSubmat(
            arrayOf(
                intArrayOf(1, 0, 1),
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 0)
            )
        )
    )
}

private fun numSubmat(mat: Array<IntArray>): Int {
    if (mat.isEmpty()) {
        return 0
    }

    var result = 0

    val sv = IntArray(mat[0].size) { 0 }

    mat.forEachIndexed { rowIndex, it ->
        it.forEachIndexed { columnIndex, value ->
            if (value == 1) {
                sv[columnIndex] += 1
            } else {
                sv[columnIndex] = 0
                return@forEachIndexed
            }

            var min = Int.MAX_VALUE
            for (visit in columnIndex downTo 0) {
                val height = sv[visit]
                if (height == 0) {
                    break
                }

                if (height < min) {
                    min = height
                }

                result += min
            }
        }
    }

    return result
}