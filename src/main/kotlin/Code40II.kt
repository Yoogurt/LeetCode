fun main() {
    println(combinationSum2(intArrayOf(), 8))
}

private fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val result = mutableSetOf<List<Int>>()
    combinationInternal(candidates, target, 0, mutableListOf(), result)
    return result.toList()
}

private fun combinationInternal(
    candidates: IntArray,
    target: Int,
    startIndex: Int,
    currentPath: MutableList<Int>,
    result: MutableSet<List<Int>>
) {
    if (startIndex > candidates.lastIndex){
        return
    }

    val subtractResult = target - candidates[startIndex]

    when {
        subtractResult == 0 -> {
            val resultPath = (currentPath + candidates[startIndex]).sorted()

            result += resultPath
        }
        subtractResult < 0 -> {

        }
        else -> {
            currentPath.add(candidates[startIndex])
            combinationInternal(
                candidates,
                subtractResult,
                startIndex + 1,
                currentPath,
                result
            )
            currentPath.removeAt(currentPath.lastIndex)
        }
    }

    combinationInternal(
        candidates,
        target,
        startIndex + 1,
        currentPath,
        result
    )
}