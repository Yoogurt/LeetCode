import java.util.*

fun main(args: Array<String>) {
    println(levelOrder(buildTreeNode(3, 9, 20, null, null, 15, 7)))
}

private fun levelOrder(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<MutableList<Int>>()

    root ?: return result
    var queue = ArrayDeque<TreeNode>().apply {
        this += root
    }

    while (queue.isNotEmpty()) {
        val newLevel = ArrayDeque<TreeNode>()
        val levelResult = mutableListOf<Int>()

        while (queue.isNotEmpty()) {
            val node = queue.pollFirst()
            levelResult += node.`val`

            node.left?.also(newLevel::addLast)
            node.right?.also(newLevel::addLast)
        }

        result += levelResult
        queue = newLevel
    }

    return result
}