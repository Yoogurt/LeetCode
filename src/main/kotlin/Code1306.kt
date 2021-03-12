fun main() {
    println(canReach(intArrayOf(4, 2, 3, 0, 3, 1, 2), 5))
    println(canReach(intArrayOf(4, 2, 3, 0, 3, 1, 2), 0))
    println(canReach(intArrayOf(3, 0, 2, 1, 2), 2))
}

/**
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
注意，不管是什么情况下，你都无法跳到数组之外。
 */

private fun canReach(arr: IntArray, start: Int): Boolean {
    val reachDestination = BooleanArray(arr.size)
    return canReach(arr, start, reachDestination)
}

private fun canReach(arr: IntArray, start: Int, result: BooleanArray): Boolean {
    if (result[start]) {
        return false
    }

    result[start] = true

    if (arr[start] == 0) {
        return true
    }

    val jumpRight = start + arr[start]
    val jumpLeft = start - arr[start]

    if (jumpLeft in result.indices) {
        if (canReach(arr, jumpLeft, result)) {
            return true
        }
    }

    if (jumpRight in result.indices) {
        if (canReach(arr, jumpRight, result)) {
            return true
        }
    }

    return false
}