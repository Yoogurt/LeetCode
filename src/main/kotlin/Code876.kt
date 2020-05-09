fun main(args: Array<String>) {
    println(middleNode(buildListNode(1, 2, 3, 4, 5,6)))
}

private fun middleNode(head: ListNode?): ListNode? {
    head ?: return null

    var fastNode: ListNode? = head
    var slowNode: ListNode? = head

    while (fastNode?.next != null) {
        fastNode = fastNode.next?.next
        slowNode = slowNode?.next
    }

    return slowNode
}