data class ListNode(@JvmField var `val`: Int, @JvmField var next: ListNode? = null)

fun buildListNode(vararg args: Int): ListNode {
    assert(args.isNotEmpty())

    val root = ListNode(args[0])
    var current = root

    repeat(args.size - 1) {
        current = ListNode(args[it + 1]).also {
            current.next = it
        }
    }

    return root
}

fun searchTreeNode(root: TreeNode?, value: Int): TreeNode? {
    root ?: return null

    if (root.`val` == value) {
        return root
    }

    return searchTreeNode(root.left, value) ?: searchTreeNode(root.right, value)
}

fun buildTreeNode(vararg args: Int?): TreeNode {
    assert(args.isNotEmpty())

    val root = TreeNode(args[0]!!)
    val queue = mutableListOf<TreeNode?>(root)

    var index = 1
    while (queue.isNotEmpty() && index < args.size) {
        val child = queue.removeAt(0) ?: continue

        var value = args.getOrNull(index++)
        if (value != null) {
            child.left = TreeNode(value)
        }

        value = args.getOrNull(index++)
        if (value != null) {
            child.right = TreeNode(value)
        }

        queue += child.left
        queue += child.right
    }

    return root
}

data class TreeNode(val `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

fun main() {
    print(buildTreeNode(5, 3, 6, 2, 4, null, null, 1))
}