fun main(args: Array<String>) {
    println(hasPathSum(buildTreeNode(1, -2, -3, 1, 3, -2, null, -1), -1))
}

private fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
    root ?: return false

    val nextSum = sum - root.`val`

    if (root.left == null && root.right == null && nextSum == 0) {
        return true
    }

    return hasPathSum(root.left, nextSum) || hasPathSum(root.right, nextSum)
}