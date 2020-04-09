fun main(args: Array<String>) {
    println(mirrorTree(buildTreeNode(4, 2, 7, 1, 3, 6, 9)))
}

fun mirrorTree(root: TreeNode?): TreeNode? {
    root ?: return null

    val right = root.right
    root.right = root.left
    root.left = right

    mirrorTree(root.left)
    mirrorTree(root.right)

    return root
}
