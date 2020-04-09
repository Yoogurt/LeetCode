fun main(args: Array<String>) {
    println(isSymmetric(buildTreeNode(1, 2, 2, 3, 4, 4, 3)))
}

fun isSymmetric(root: TreeNode?): Boolean {
    return isMirror(root?.left, root?.right)
}

private fun isMirror(left: TreeNode?, right: TreeNode?): Boolean {
    if (left == null || right == null) {
        return left == right
    }

    if (left.`val` != right.`val`) {
        return false
    }

    return isMirror(left.right, right.left) && isMirror(left.left, right.right)
}