import kotlin.math.absoluteValue

fun main() {
    println(findTilt(buildTreeNode(1, 2, 3)))
    println(findTilt(buildTreeNode(4, 2, 9, 3, 5, null, 7)))
    println(findTilt(buildTreeNode(21, 7, 14, 1, 1, 2, 2, 3, 3)))
}

val resultCache = mutableMapOf<TreeNode, Int>()

private fun findTilt(root: TreeNode?): Int {
    root ?: return 0

    val left = root.left
    val right = root.right

    return (sumCountOf(left) - sumCountOf(right)).absoluteValue + findTilt(left) + findTilt(right)
}

private fun sumCountOf(treeNode: TreeNode?): Int {
    treeNode ?: return 0
    return resultCache.getOrElse(treeNode) {
        treeNode.`val` + sumCountOf(treeNode.left) + sumCountOf(treeNode.right)
    }
}