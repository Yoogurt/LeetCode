fun main(args: Array<String>) {
    val root = buildTreeNode(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5)

    println(lowestCommonAncestor(root, searchTreeNode(root, 2), searchTreeNode(root, 8)))
    println(lowestCommonAncestor(root, searchTreeNode(root, 2), searchTreeNode(root, 4)))
}

private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    root ?: return null
    p ?: return null
    q ?: return null

    var p = p
    var q = q

    if (p.`val` > q.`val`) {
        val tmp = p
        p = q
        q = tmp
    }

    return if (root.`val` >= p.`val` && root.`val` <= q.`val`) {
        root
    } else if (root.`val` > p.`val`) {
        lowestCommonAncestor(root.left, p, q)
    } else {
        lowestCommonAncestor(root.right, p, q)
    }
}