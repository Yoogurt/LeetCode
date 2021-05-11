fun main() {
    println(getLonelyNodes(buildTreeNode(1, 2, 3, null, 4)))
}

private fun getLonelyNodes(root: TreeNode?): List<Int> {
    root ?: return emptyList()
    val result = mutableListOf<Int>()
    getLonelyNode(root, result)
    return result
}

private fun getLonelyNode(node: TreeNode, result: MutableList<Int>) {
    val leftNull = node.left == null
    val rightNull = node.right == null

    if (leftNull xor rightNull) {
        result += (node.left?.`val` ?: node.right?.`val`)!!
    }

    node.left?.also { getLonelyNode(it, result) }
    node.right?.also { getLonelyNode(it, result) }
}