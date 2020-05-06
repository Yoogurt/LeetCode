import kotlin.math.abs
import kotlin.math.max

fun main(args: Array<String>) {
    println(isBalanced(buildTreeNode(3, 9, 20, null, null, 15, 7,1)))
}

private fun isBalanced(root: TreeNode?): Boolean {
    root ?: return true

    return isBalanced(root.left) && isBalanced(root.right) && abs(getDepth(root.left) - getDepth(root.right)) < 2
}

private fun getDepth(root: TreeNode?): Int {
    root ?: return 0

    return max(getDepth(root.left), getDepth(root.right)) + 1
}