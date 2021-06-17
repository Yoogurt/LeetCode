fun main() {
    print(zigzagLevelOrder(buildTreeNode(3,9,20,null,null,15,7)))
}

private fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    root ?: return emptyList()

    var queue = mutableListOf<TreeNode>()
    queue.add(root)

    val result = mutableListOf<List<Int>>()
    var reversed = true

    while (queue.isNotEmpty()) {
        val layer = queue
        val newQueue = mutableListOf<TreeNode>()
        val layerResult = mutableListOf<Int>()

        while (layer.isNotEmpty()) {
            val node = layer.removeAt(0)
            layerResult += node.`val`

            if (reversed) {
                var index = 0
                node.right?.also { newQueue.add(index++, it) }
                node.left?.also { newQueue.add(index++, it) }
            } else {
                var index = 0
                node.left?.also {  newQueue.add(index++, it) }
                node.right?.also {  newQueue.add(index++, it) }
            }
        }

        reversed = !reversed
        result += layerResult
        queue = newQueue
    }

    return result
}