fun main(args: Array<String>) {
    print(pathSum(buildTreeNode(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), 8))
}

private fun pathSum(root: TreeNode?, sum: Int): Int {
    root ?: return 0

    var result = 0

    result += pathSum(root.left, sum)
    result += pathSum(root.right, sum)

    if (sum == root.`val`) {
        result++
    }

    result += pathIncludeRoot(root.left, sum - root.`val`) + pathIncludeRoot(root.right, sum - root.`val`)

    return result
}

private fun pathIncludeRoot(root: TreeNode?, sum: Int): Int {
    root ?: return 0

    var result = 0
    if (sum == root.`val`) {
        result++
    }

    result += pathIncludeRoot(root.left, sum - root.`val`) + pathIncludeRoot(root.right, sum - root.`val`)

    return result
}