import java.util.Stack
import javax.swing.plaf.nimbus.State
import kotlin.math.max

fun main() {
    println(longestValidParentheses("(()(())"))
}

private fun longestValidParentheses(s: String): Int {
    var result = 0

    val latestPositions = Stack<Int>()

    val chars = s.toCharArray()
    val lastSeriesCount = IntArray(chars.size) { 0 }

    chars.forEachIndexed { indexed, it ->
        when (it) {
            '(' -> {
                latestPositions.push(indexed)
            }

            ')' -> {
                if (!latestPositions.empty()) {
                    val latestPosition = latestPositions.pop()

                    var seriesToNowLength = indexed - latestPosition + 1
                    seriesToNowLength += lastSeriesCount.getOrNull(latestPosition - 1) ?: 0

                    result = max(result, seriesToNowLength)

                    lastSeriesCount[indexed] = seriesToNowLength
                }
            }
        }
    }

    return result
}