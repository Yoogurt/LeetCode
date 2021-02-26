fun main() {
    println(sumNumbers(buildTreeNode(4,1,null,3,2)))
}

private fun sumNumbers(root: TreeNode?): Int {
    root ?: return 0

    val left = root.left
    val right = root.right

    if (left == null && right == null){
        return root.`val`
    }

    return childNodePathValue(root.`val`, root.left) + childNodePathValue(root.`val`, root.right)
}

private fun getPathSum(parentPath: Int, childNode: TreeNode): Int {
    val parentPath = parentPath * 10 + childNode.`val`
    val left = childNode.left
    val right = childNode.right

    if (left == null && right == null){
        return parentPath
    }

    return childNodePathValue(parentPath, left) + childNodePathValue(parentPath, right)
}

private fun childNodePathValue(parentPath: Int, node: TreeNode?): Int =
    run { getPathSum(parentPath, node ?: return@run 0) }