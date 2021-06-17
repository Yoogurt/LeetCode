import java.util.*

fun main() {

}

private fun maximumGap(nums: IntArray): Int {
    val stack = Stack<Int>()
    var result = 0

    nums.forEach {
        var lastPop = 0

        while (stack.isNotEmpty() && stack.peek() < it){
            lastPop = stack.pop()
        }

        stack.push(it)

    }

    return result
}