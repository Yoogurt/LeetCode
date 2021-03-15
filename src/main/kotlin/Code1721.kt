import java.util.*

fun main() {
    println(trap(intArrayOf(1,3,2,1,2,1)))
}

private fun Stack<Int>.topOrNotFound(): Int = if (isEmpty()) {
    -1
} else {
    first()
}

private fun trap(height: IntArray): Int {
    val elementLeft = IntArray(height.size) { -1 }
    val elementRight = IntArray(height.size) { height.size }

    val stack = Stack<Int>()

    height.indices.forEach {
        if (stack.isEmpty()){
            stack.push(it)
            return@forEach
        }

        while (stack.isNotEmpty() && height[stack.peek()] <= height[it]){
            elementRight[stack.pop()] = it
        }

        elementLeft[it] = stack.topOrNotFound()
        stack.push(it)
    }


    var result= 0

    return result
}