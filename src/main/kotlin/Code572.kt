fun main(args: Array<String>) {
    println(isSubtree(buildTreeNode(3, 4, 5, 1, 2, null, null), buildTreeNode(4, 1, 2)))
}

private fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
    t ?: return true
    s ?: return false

    return isSubTreeInternal(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t)
}

private fun isSubTreeInternal(root: TreeNode?, t: TreeNode?): Boolean {
    t ?: root ?: return true
    t ?: return false
    root ?: return false

    return root.`val` == t.`val` && isSubTreeInternal(root.left, t.left) && isSubTreeInternal(root.right, t.right)
}