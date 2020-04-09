import java.util.*

fun main() {
    println(preorderTraversal(buildTreeNode(1, 5, 2, 3, 4, 6, null)))
}

private fun preorderTraversal(root: TreeNode?): List<Int> {
    val stack = Stack<TreeNode>()
    val result = Stack<Int>()
    stack.push(root ?: return result)

    while (stack.isNotEmpty()) {
        val node = stack.pop()

        result.push(node.`val`)

        if (node.left != null) {
            stack.push(node.left)
        }

        if (node.right != null) {
            stack.push(node.right)
        }
    }

    return result.toList().reversed()
}