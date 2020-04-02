fun main(vararg args: String) {
    val root = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))

    print(reverseKGroup(root, 2))
}

private fun reverseKGroup(node: ListNode?, k: Int): ListNode? {
    node ?: return null

    if (k == 1) {
        return node
    }

    var pre: ListNode? = node
    var current: ListNode? = node.next
    var head: ListNode? = null
    var lastNodeToLink: ListNode? = null
    var index = 2
    while (current != null) {
        if (index >= k) {
            index = 1
            head = head ?: current
            val next = current.next
            lastNodeToLink = reserveInternal(pre, lastNodeToLink, k)
            current = next
            pre = current
        } else {
            index++
            current = current.next
        }
    }

    lastNodeToLink?.next = pre
    return head!!
}

// return last
private fun reserveInternal(head: ListNode?, headToLink: ListNode?, group: Int): ListNode? {
    if (head == null) {
        return null
    }

    var left = head

    var current = head.next
    var next = current?.next

    left.next = null
    var count = 1

    while (current != null && count < group) {
        current.next = left
        left = current
        current = next
        next = next?.next
        count++
    }

    headToLink?.next = left
    return head
}