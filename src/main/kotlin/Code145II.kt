import java.util.*

fun main() {
    println(postorderTraversal(buildTreeNode(1, 2, 3, 4, 5, 6, 7)))
}

private fun postorderTraversal(root: TreeNode?): List<Int> {
    val stack = Stack<TreeNode>()
    val result = mutableListOf<Int>()

    stack.push(root)

    while (stack.isNotEmpty()) {
        val listNode = stack.peek()

        var push = false

        if (listNode.right != null) {
            stack.push(listNode.right)
            listNode.right = null
            push = true
        }

        if (listNode.left != null) {
            stack.push(listNode.left)
            listNode.left = null
            push = true
        }

        if (!push) {
            result += stack.pop().`val`
        }
    }

    return result
}