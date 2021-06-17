import kotlin.jvm.internal.Ref

fun main() {

}

private fun totalNQueens(n: Int): Int {
    val result = Ref.IntRef()
    backTrack(0, n, IntArray(n) { -1 }, result)
    return result.element
}

private fun backTrack(row: Int, total: Int, placeInfo: IntArray, result: Ref.IntRef) {
    if (row == total) {
        result.element++
        return
    }

    repeat(total) {
        if (canPlace(row, it, placeInfo)) {
            placeInfo[row] = it
            backTrack(row + 1, total, placeInfo, result)
            placeInfo[row] = -1
        }
    }
}

private fun canPlace(row: Int, index: Int, info: IntArray): Boolean {
    return (0 until row).all {
        val placeIndex = info[it]
        placeIndex != -1 && placeIndex != index && index != placeIndex + (row - it) && index != placeIndex - (row - it)
    }
}