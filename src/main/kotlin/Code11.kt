import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {
    println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
}

private fun maxArea(height: IntArray): Int {
    if (height.size <= 1) {
        return 0
    }

    var left = 0
    var right = height.lastIndex
    var maxArea = 0
    while (left < right) {
        maxArea = max(maxArea, (right - left) * min(height[left], height[right]))

        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }

    return maxArea
}