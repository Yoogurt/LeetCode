import java.util.*

fun main(args: Array<String>) {
    val stack = MinStack()

    stack.push(-2)
    stack.push(0)
    stack.push(-3)
    stack.pop()
    stack.push(-4)
    println(stack.getMin())
    stack.push(0)
    stack.push(-3)
    stack.pop()
    stack.push(-2)
    println(stack.getMin())
    stack.push(0)
    stack.push(-3)
    stack.pop()
    stack.pop()

    println(stack.getMin())

    println(stack.top())
    println(stack.getMin())
}

class MinStack() {
    /** initialize your data structure here. */

    private val queue = Stack<Int>()
    private var min = Int.MAX_VALUE

    fun push(x: Int) {
        queue.push(min)
        queue.push(x)
        if (min > x) {
            min = x
        }
    }

    fun pop() {
        queue.pop()
        min = queue.pop()
    }

    fun top(): Int {
        return queue.peek()
    }

    fun getMin(): Int {
        return min
    }
}