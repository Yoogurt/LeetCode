fun main() {
    println(trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
}

private fun trap(height: IntArray): Int {
    val leftHeight = IntArray(height.size) { 0 }
    val rightHeight = IntArray(height.size) { 0 }

    var max = 0
    height.forEachIndexed { indexed, it ->
        leftHeight[indexed] = max
        max = maxOf(max, it)
    }

    max = 0

    (height.lastIndex downTo 0).forEach { indexed ->
        rightHeight[indexed] = max
        max = maxOf(max, height[indexed])
    }

    return height.foldIndexed(0) { indexed, left, right ->
        val shorter = minOf(leftHeight[indexed], rightHeight[indexed])
        left + maxOf(0,  shorter - right)
    }
}