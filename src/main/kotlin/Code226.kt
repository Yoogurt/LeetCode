fun main() {
    println(invertTree(buildTreeNode(1, 2, 3, 4, 5, 6, 7)))
}

private fun invertTree(root: TreeNode?): TreeNode? {
    root ?: return null

    val tempNode = root.left
    root.left = root.right
    root.right = tempNode

    invertTree(root.left)
    invertTree(root.right)

    return root
}