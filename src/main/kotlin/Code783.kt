import com.sun.source.tree.Tree
import kotlin.math.min

fun main() {
    println(minDiffInBST(buildTreeNode(4, 2, 6, 0, 3, null, null)))
    println(minDiffInBST(buildTreeNode(90, 69, null, 49, 88, null, 52)))
    println(minDiffInBST(buildTreeNode(56, 42, 77, 23, 51, 75, 90, null, null, null, null, 67, null, 78, 99)))
}

private fun minDiffInBST(root: TreeNode?): Int {
    root ?: return Int.MAX_VALUE

    val left = littleLessNode(root)?.let {
        root.`val` - it.`val`
    } ?: Int.MAX_VALUE

    val right = littleMoreNode(root)?.let {
        it.`val` - root.`val`
    } ?: Int.MAX_VALUE

    return minOf(minOf(left, right), minDiffInBST(root.left), minDiffInBST(root.right))
}

private fun littleLessNode(node: TreeNode): TreeNode? {
    var left = node.left ?: return null

    while (left.right != null) {
        left = left.right!!
    }

    return left
}

private fun littleMoreNode(node: TreeNode): TreeNode? {
    var right = node.right ?: return null

    while (right.left != null) {
        right = right.left!!
    }

    return right
}

