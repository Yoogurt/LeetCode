import kotlin.math.abs

fun main() {
    println(closestValue(buildTreeNode(4, 2, 5, 1, 3), 3.2))
}

private fun closestValue(root: TreeNode?, target: Double): Int {
    root ?: return Int.MAX_VALUE

    val bias = abs(root.`val` - target)

    return when {
        target > root.`val` -> minOf(root.`val`, bias, closestValue(root.right, target), target)
        target < root.`val` -> minOf(root.`val`, bias, closestValue(root.left, target), target)
        else -> root.`val`
    }
}

private fun minOf(oldVal: Int, bias: Double, newVal: Int, target: Double): Int {
    return if (bias < abs(newVal - target)) oldVal else newVal
}