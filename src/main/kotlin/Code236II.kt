fun main() {
    val node = buildTreeNode(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)

    println(lowestCommonAncestor(node, searchTreeNode(node, 5), searchTreeNode(node, 1)))
}

private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    root ?: return null

    if (root == p || root == q) {
        return root
    }

    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)

    return when {
        left != null && right != null -> root
        else -> left ?: right
    }
}