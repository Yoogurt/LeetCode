import java.util.*

fun main(args: Array<String>) {
    println(isValid("()()(())[]"))
}

private fun isValid(s: String): Boolean {
    if (s.isEmpty()) {
        return true
    }

    val stack = Stack<Char>()
    val chars = s.toCharArray()

    chars.forEach {
        when (it) {
            '(', '{', '[' -> {
                stack.push(it)
            }
            ')' -> {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false
                }
            }
            '}' -> {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false
                }
            }
            ']' -> {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false
                }
            }
        }
    }

    return stack.isEmpty()
}