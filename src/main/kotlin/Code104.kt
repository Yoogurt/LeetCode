fun main() {
    println(maxDepth(buildTreeNode(3, 9, 20, null, null, 15, 7)))
}

private fun maxDepth(tree: TreeNode?): Int {
    tree ?: return 0

    return kotlin.math.max(maxDepth(tree.left), maxDepth(tree.right)) + 1
}