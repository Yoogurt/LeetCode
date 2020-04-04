import java.util.*

fun main() {
    print(preorderTraversal(buildTreeNode(1, 5, 2, 3, 4)))
}

private fun preorderTraversal(root: TreeNode?): List<Int> {
    val stack = Stack<TreeNode>()
    val result = mutableListOf<Int>()
    var current: TreeNode? = root ?: return result

    while (current != null || stack.isNotEmpty()) {

        while (current != null) {
            result += current.`val`
            stack.push(current)
            current = current.left
        }

        current = stack.pop()
        current = current.right
    }

    return result
}