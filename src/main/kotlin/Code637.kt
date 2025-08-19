import kotlin.math.abs

fun main() {
    println(averageOfLevels(buildTreeNode(1, 2, 3, 4, 5, 6, 7)).contentToString())
}

data class Pair(
    var first: Int = 0,
    var second: Double = 0.0
)

fun visitTree(treeNode: TreeNode?, result: Array<Pair>, depth: Int) {
    treeNode ?: return
    result[depth].first++
    result[depth].second += treeNode.`val`
    visitTree(treeNode.left, result, depth + 1)
    visitTree(treeNode.right, result, depth + 1)
}

fun averageOfLevels(root: TreeNode?): DoubleArray {
    val result = Array(1001) { Pair() }
    visitTree(root, result, 0)
    return result.filter { it.first > 0 }.map { it.second / it.first }.toDoubleArray()
}