import java.util.*

fun main() {
    print(inorderTraversal(buildTreeNode(1, 5, 2, 3,4)))
}

private fun inorderTraversal(root: TreeNode?): List<Int> {
    val stack = Stack<TreeNode>()
    val result = mutableListOf<Int>()
    var current: TreeNode? = root ?: return result

    while (current != null || stack.isNotEmpty()) {

        while (current != null){
            stack.push(current)
            current = current.left
        }

        current = stack.pop()
        result += current.`val`
        current = current.right
    }

    return result
}