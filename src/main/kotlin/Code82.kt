fun main() {
    println(deleteDuplicates(buildListNode(4, 1, 1, 2, 2, 3, 3, 3, 3)))
}

private fun removeDuplicateNode(node: ListNode): ListNode? {
    val currentValue = node.`val`
    var scanNode: ListNode? = node.next

    return if (currentValue == scanNode?.`val`) {
        while (scanNode != null && currentValue == scanNode.`val`) {
            scanNode = scanNode.next
        }
        scanNode
    } else {
        node
    }
}

private fun deleteDuplicates(head: ListNode?): ListNode? {
    var head = removeDuplicateNode(head ?: return null)

    while (true) {
        val oldHead = head
        head = removeDuplicateNode(head ?: return null)
        if (oldHead == head) {
            break
        }
    }

    var scan = head
    while (scan != null) {
        val next = scan.next ?: return head

        val oldNext = scan.next
        scan.next = removeDuplicateNode(next)
        if (oldNext == scan.next) {
            scan = oldNext
        }
    }

    return head
}