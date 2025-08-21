import kotlin.math.max

fun main() {
    println(findSecondMinimumValue(buildTreeNode(5, 8, 5)))
}

private fun findSecondMinimumValue(root: TreeNode?): Int {
    root ?: return -1

    val currentValue = root.`val`

    if (root.left?.`val` == currentValue) {
        if (root.right!!.`val` != currentValue) {
            return root.right!!.`val`
        }
    }

    if (root.right?.`val` == currentValue) {
        if (root.left!!.`val` != currentValue) {
            return root.left!!.`val`
        }
    }

    val left = findSecondMinimumValue(root.left)
    val right = findSecondMinimumValue(root.right)

    return max(left, right)
}