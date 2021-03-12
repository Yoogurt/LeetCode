fun main() {
    println(rangeSumBST(buildTreeNode(10,5,15,3,7,13,18,1,null,6), 6, 10))
}

private fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
    root ?: return 0

    return (root.`val`.takeIf { it in low..high } ?: 0) + rangeSumBST(root.left, low, high) + rangeSumBST(
        root.right,
        low,
        high
    )
}