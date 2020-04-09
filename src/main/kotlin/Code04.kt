import kotlin.math.abs
import kotlin.math.max

fun main() {
    println(isBalanced(buildTreeNode(1, 2, 2, 3, 3, null, null, 4, 4)))
}

private fun isBalanced(root: TreeNode?): Boolean {
    root ?: return true

    return isBalanced(root.left) && isBalanced(root.right) && abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
}

private fun maxDepth(root: TreeNode?): Int {
    root ?: return 0

    return max(maxDepth(root.left), maxDepth(root.right)) + 1
}