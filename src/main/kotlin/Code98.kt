import kotlin.jvm.internal.Ref

fun main(args: Array<String>) {
    println(isValidBST(buildTreeNode(10, 5, 15, null, null, 6, 20)))
}

private fun isValidBST(root: TreeNode?): Boolean {
    return inOrder(root, Ref.ObjectRef<Int?>())
}

private fun inOrder(node: TreeNode?, last: Ref.ObjectRef<Int?>): Boolean {
    node ?: return true

    if (!inOrder(node.left, last)) {
        return false
    }

    if (last.element != null && node.`val` <= last.element!!) {
        return false
    }

    last.element = node.`val`

    if (!inOrder(node.right, last)) {
        return false
    }

    return true
}