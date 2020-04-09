fun main(args: Array<String>) {
    println(kthSmallest(buildTreeNode(5, 3, 6, 2, 4, null, null, 1), 3))
}

private data class IntRef(var data: Int)

private fun kthSmallest(root: TreeNode?, k: Int): Int {
    if (root == null) {
        return 0
    }

    return rec(root, IntRef(k))!!.`val`
}

private fun rec(node: TreeNode?, k: IntRef): TreeNode? {
    node ?: return null

    val left = rec(node.left, k)

    if (left != null) {
        return left
    }

    k.data--

    if (k.data == 0) {
        return node
    }

    return rec(node.right, k)
}