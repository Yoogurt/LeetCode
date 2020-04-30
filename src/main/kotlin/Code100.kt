fun main(args: Array<String>) {
    println(isSameTree(buildTreeNode(1, 2, 3, 4, 5), buildTreeNode(1, 2, 3, 4, 5)))
    println(isSameTree(buildTreeNode(1, 2, 3, 5), buildTreeNode(1, 2, 3, 4, 5)))
}

private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    p ?: q ?: return true

    return p?.`val` == q?.`val` && isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
}