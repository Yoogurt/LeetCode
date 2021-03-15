package offer

import TreeNode
import buildTreeNode

fun main() {
    println(levelOrder(buildTreeNode(3, 9, 20, null, null, 15, 7)).contentToString())
}

private fun levelOrder(root: TreeNode?): IntArray {
    root ?: return intArrayOf()

    val array = mutableListOf(root)
    val result = mutableListOf<Int>()

    while (array.isNotEmpty()) {
        val node = array.removeAt(0)
        node.left?.also {
            array += it
        }
        node.right?.also {
            array += it
        }
        result += node.`val`
    }

    return result.toIntArray()
}