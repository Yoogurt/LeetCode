package interview

import TreeNode
import buildTreeNode

fun main(args: Array<String>) {
    println(pathSum(buildTreeNode(1, -2, -3, 1, 3, -2, null, -1), 3))
}

fun pathSum(node: TreeNode?, sum: Int): Int {
    node ?: return 0
    return sumOf(node, 0, sum) + pathSum(node.left, sum) + pathSum(node.right, sum)
}

private fun sumOf(node: TreeNode?, currentSum: Int, originSum: Int): Int {
    node ?: return 0

    val left = node.left
    val right = node.right

    val currentSum = currentSum + node.`val`

    return if (currentSum == originSum) {
        1
    } else {
        0
    } + sumOf(left, currentSum, originSum) + sumOf(right, currentSum, originSum)
}