import kotlin.jvm.internal.Ref

fun main(args: Array<String>) {
    println(kthLargest(buildTreeNode(5, 3, 6, 2, 4, null, null, 1), 3))
}

fun kthLargest(root: TreeNode?, k: Int): Int {
    return kthLargest(root, Ref.IntRef().also {
        it.element = k
    })!!.`val`
}

fun kthLargest(root: TreeNode?, k: Ref.IntRef): TreeNode? {
    root ?: return null

    return kthLargest(root.right, k) ?: if (k.element == 0) {
        root
    } else {
        k.element--

        if (k.element == 0) {
            root
        } else {
            kthLargest(root.left, k)
        }
    }
}