fun main(args: Array<String>) {
    println(removeNthFromEnd(buildListNode(1, 2, 3, 4, 5), 2))
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    head ?: return null

    var fastNode: ListNode? = head

    repeat(n) {
        fastNode = fastNode?.next
    }

    var slowNode: ListNode? = null

    while (fastNode != null) {
        fastNode = fastNode?.next

        slowNode = if (slowNode == null) {
            head
        } else {
            slowNode.next
        }
    }

    slowNode?.next = slowNode?.next?.next

    return if (slowNode == null) {
        head.next
    } else {
        head
    }
}