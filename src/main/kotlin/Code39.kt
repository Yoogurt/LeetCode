package main.kotlin

fun main() {
    println(combinationSum(intArrayOf(0), 7))
}

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    if (candidates.isEmpty()) {
        return mutableListOf()
    }

    candidates.sort()

    val candidate = candidates.copyOfRange(candidates.indexOfFirst {
        it != 0
    }.also {
        if (it == -1) {
            return mutableListOf()
        }
    }, candidates.size)

    val result = mutableListOf<List<Int>>()

    combinationInternal(candidate, mutableListOf(), target, result)
    return result
}

private fun combinationInternal(data: IntArray, currentPath: MutableList<Int>, target: Int, result: MutableList<List<Int>>) {
    if (target == 0) {
        result += currentPath
        return
    }

    data.forEachIndexed { index, it ->
        if (target - it >= 0) {
            combinationInternal(data.copyOfRange(index, data.size), (currentPath + it).toMutableList(), target - it, result)
        } else {
            return
        }
    }
}