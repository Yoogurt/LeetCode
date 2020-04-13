package main.kotlin

import TreeNode
import buildTreeNode
import kotlin.jvm.internal.Ref
import kotlin.math.max


fun main(args: Array<String>) {
    println(maxPathSum(buildTreeNode(-2, 1)))
}

private fun helper(root: TreeNode?, max: Ref.IntRef): Int {
    root ?: return 0

    if (root.left == null && root.right == null) {
        max.element = max(max.element, root.`val`)
        return root.`val`
    }

    val left = helper(root.left, max)
    val right = helper(root.right, max)

    val selfSum = root.`val` + left + right
    val leftSum = root.`val` + left
    val rightSum = root.`val` + right

    max.element = maxOf(max.element, selfSum, maxOf(leftSum, rightSum, root.`val`))

    return maxOf(leftSum, rightSum, root.`val`)
}

fun maxPathSum(root: TreeNode?): Int {
    root ?: return 0

    val ref = Ref.IntRef().also {
        it.element = root.`val`
    }

    helper(root, ref)
    return ref.element
}