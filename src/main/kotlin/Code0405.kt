fun main() {
//    println(isValidBST(buildTreeNode(2, 1, 3)))
//    println(isValidBST(buildTreeNode(5, 1, 4, 3, 6)))
//    println(isValidBST(buildTreeNode(10, 5, 15, null, null, 15, 20)))
    println(isValidBST(buildTreeNode(Int.MAX_VALUE, Int.MIN_VALUE)))
}

private fun isValidBST(root: TreeNode?): Boolean {
    return isValidBST(root, null, null)
}

private fun isValidBST(root: TreeNode?, lower: Int?, higher: Int?): Boolean {
    root ?: return true
    val `val` = root.`val`
    return (lower == null || `val` > lower) &&
            (higher == null || `val` < higher)
            && isValidBST(root.left, lower, `val`)
            && isValidBST(root.right, `val`, higher)
}