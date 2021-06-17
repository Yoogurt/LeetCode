import kotlin.jvm.internal.Ref

fun main() {
    println(buildTree(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7)))
}

private fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    val ref = Ref.IntRef()
    return rebuild(preorder, inorder.toList(), ref)
}

private fun rebuild(preorder: IntArray, inorder: List<Int>, current: Ref.IntRef): TreeNode? {
    if (inorder.isEmpty()) return null
    val inIndex = current.element
    if (inIndex > preorder.lastIndex) return null

    val node = TreeNode(preorder[inIndex])

    val inorderIndex = inorder.indexOf(preorder[inIndex])

    current.element++
    node.left = rebuild(preorder, inorder.subListSafe(0 until inorderIndex), current)
    node.right = rebuild(preorder, inorder.subListSafe(inorderIndex + 1 until preorder.size), current)

    return node
}