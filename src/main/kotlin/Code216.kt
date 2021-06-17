import java.lang.Exception

fun main() {
}

private fun combinationSum3(k: Int, n: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    backTrack(mutableListOf(), 1, n, k, result)
    return result
}

private fun backTrack(
    current: MutableList<Int>,
    index: Int,
    remain: Int,
    remainCount: Int,
    result: MutableList<List<Int>>
) {
    if (remain == 0 && remainCount == 0) {
        result += current.toList()
        return
    }

    if (remain < 0 || index > 9 || remainCount == 0) {
        return
    }

    current += index
    backTrack(current, index + 1, remain - index, remainCount - 1, result)
    current.removeAt(current.lastIndex)

    backTrack(current, index + 1, remain, remainCount, result)
}