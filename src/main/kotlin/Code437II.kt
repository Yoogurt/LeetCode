fun main() {
    println(pathSum(buildTreeNode(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), 8))
    println(pathSum(buildTreeNode(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22))
}

private fun pathSum(root: TreeNode?, targetSum: Int): Int {
    root ?: return 0

    var result = 0

    val remain = targetSum - root.`val`

    if (remain == 0) {
        result++
    }
    result += pathSumIncludeParent(root.left, remain)
    result += pathSumIncludeParent(root.right, remain)
    result += pathSum(root.left, targetSum)
    result += pathSum(root.right, targetSum)

    return result
}

private fun pathSumIncludeParent(root: TreeNode?, targetSum: Int): Int {
    root ?: return 0

    var result = 0
    val remain = targetSum - root.`val`

    if (remain == 0) {
        result++
    }
    result += pathSumIncludeParent(root.left, remain)
    result += pathSumIncludeParent(root.right, remain)

    return result
}