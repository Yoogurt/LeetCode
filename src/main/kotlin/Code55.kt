import kotlin.math.max

fun main() {
    println(maxDepth(buildTreeNode(3, 9, 20, null, null, 15, 7)))
}

private fun maxDepth(root: TreeNode?): Int {
    root ?: return 0

    return max(maxDepth(root.left), maxDepth(root.right)) + 1
}