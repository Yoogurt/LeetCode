fun main(args: Array<String>) {
    val ret = buildTreeNode(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)

    println(lowestCommonAncestor2(ret, searchTreeNode(ret, 5), searchTreeNode(ret, 1)))
}

fun lowestCommonAncestor2(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    root ?: return null
    p ?: return null
    q ?: return null

    if (root == p || root == q) {
        return root
    }

    val left = lowestCommonAncestor2(root.left, p, q)
    val right = lowestCommonAncestor2(root.right, p, q)

    return if (left != null && right != null) {
        root
    } else {
        left ?: right
    }
}
