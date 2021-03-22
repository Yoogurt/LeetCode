fun main(args: Array<String>) {
    println(pathSum(buildTreeNode(1), 22))
}

private fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
    root ?: return listOf()

    val result = mutableListOf<List<Int>>()
    checkPath(mutableListOf(), sum, root, result)
    return result
}

private fun checkPath(path: MutableList<Int>, nextSum: Int, currentNode: TreeNode, result: MutableList<List<Int>>) {
    val sum = nextSum - currentNode.`val`

    path += currentNode.`val`
    if (currentNode.left == null && currentNode.right == null && sum == 0) {
        result += path
    } else {
        val left = currentNode.left
        val right = currentNode.right

        if (left != null) {
            checkPath(ArrayList(path), sum, left, result)
        }
        if (right != null) {
            checkPath(ArrayList(path), sum, right, result)
        }
    }
}