import kotlin.jvm.internal.Ref

fun main() {
    println(kthLargest(buildTreeNode(3, 1, 4, null, 2), 2))
}

private fun kthLargest(root: TreeNode?, k: Int): Int {
    val ref = Ref.IntRef().apply {
        element = k
    }
    return kthLargest2(root, ref)!!
}

private fun kthLargest2(root: TreeNode?, k: Ref.IntRef): Int? {
    root ?: return null

    return kthLargest2(root.right, k) ?: run {
        if (k.element == 1) {
            return root.`val`
        }

        k.element--
        null
    } ?: kthLargest2(root.left, k)
}