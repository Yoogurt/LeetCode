fun main(args: Array<String>) {
    println(reverseListRec(buildListNode(1, 5, 3, 4, 5)))
}

private fun reverseList(head: ListNode?): ListNode? {
    head ?: return null

    var pre: ListNode? = null
    var current = head
    var next: ListNode? = head.next

    while (current != null) {
        current.next = pre
        pre = current
        current = next
        next = next?.next
    }

    return pre
}

private fun reverseListRec(current: ListNode?): ListNode? {
    current?.next ?: return current

    val next = reverseListRec(current.next)

    current.next!!.next = current
    current.next = null

    return next
}