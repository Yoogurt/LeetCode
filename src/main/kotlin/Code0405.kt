fun main() {
    println(isValidBST(buildTreeNode(2, 1, 3)))
    println(isValidBST(buildTreeNode(5, 1, 4, 3, 6)))
    println(isValidBST(buildTreeNode(10,5,15,null,null,15,20)))
}

private fun isValidBST(root: TreeNode?): Boolean {
    return isValidBST(root, Int.MIN_VALUE, Int.MAX_VALUE)
}

private fun isValidBST(root: TreeNode?, lower: Int, higher: Int): Boolean {
    root ?: return true
    val `val` = root.`val`
    return `val` in lower..higher
            && isValidBST(root.left, lower, `val` - 1)
            && isValidBST(root.right, `val` + 1, higher)

}