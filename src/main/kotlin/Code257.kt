fun main(args: Array<String>) {
    println(binaryTreePaths(null))
}

private fun binaryTreePaths(root: TreeNode?): List<String> {
    val result = mutableListOf<String>()

    visitTree(root, "", result)

    return result
}

private fun visitTree(node: TreeNode?, currentPath: String, result: MutableList<String>) {
    node ?: return

    val left = node.left
    val right = node.right

    val currentPath = "$currentPath${if (currentPath.isNotEmpty()) {
        "->"
    } else {
        ""
    }
    }${node.`val`}"

    if (left == null && right == null) {
        result += currentPath
        return
    }

    visitTree(left, currentPath, result)
    visitTree(right, currentPath, result)
}