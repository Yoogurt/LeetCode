import kotlin.math.min

fun main() {
    println(minDepth(buildTreeNode(1, null, 2)))
}

private fun minDepth(root: TreeNode?): Int {
    root ?: return 0

    val left = root.left
    val right = root.right

    if (left == null && right == null) {
        return 1
    }

    return when {
        left == null -> {
            minDepth(right)
        }
        right == null -> {
            minDepth(left)
        }
        else -> {
            min(minDepth(left), minDepth(right))
        }
    } + 1
}