fun main(args: Array<String>) {
    println(mergeTrees(buildTreeNode(1, 3, 2, 5), buildTreeNode(2, 1, 3, null, 4, null, 7)))
}

private fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
    (t1 ?: t2) ?: return null
    val node = TreeNode((t1?.`val` ?: 0) + (t2?.`val` ?: 0))

    node.left = mergeTrees(t1?.left, t2?.left)
    node.right = mergeTrees(t1?.right, t2?.right)
    return node
}