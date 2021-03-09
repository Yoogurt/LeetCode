import java.util.*

fun main() {
    println(removeDuplicates("abbaca"))
}

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
在 S 上反复执行重复项删除操作，直到无法继续删除。
在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

示例：
输入："abbaca"
输出："ca"
解释：
例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "
 */
private fun removeDuplicates(S: String): String {
    val stack = Stack<Char>()

    S.forEach {
        if (stack.isEmpty()) {
            stack.push(it)
            return@forEach
        }

        if (it != stack.peek()) {
            stack.push(it)
        } else {
            stack.pop()
        }
    }

    return String(stack.toCharArray())
}