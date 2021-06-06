fun main() {
//    val list = buildListNode(1, 2, 3, 4,5)
//    reorderList(list)
//    println(list)

    val list = buildListNode(1, 2, 3, 4)
    reorderList(list)
    println(list)
}

private fun findMiddle(head: ListNode?): ListNode? {
    var fast = head?.next
    var slow = head

    while (fast != null && slow != null) {
        fast = fast.next?.next
        slow = slow.next
    }

    return slow
}

private fun reverse(node: ListNode?): ListNode? {
    val next = node?.next ?: return node

    val head = reverse(node.next)
    next.next = node
    node.next = null
    return head
}

private fun reorderList(head: ListNode?): Unit {
    val middle = findMiddle(head) ?: return
    val reserved = reverse(middle)

    var pointer1: ListNode? = head
    var pointer2: ListNode? = reserved

    while (pointer1 != null && pointer1 != reserved && pointer2 != null) {
        val tempPointer = pointer1.next
        val tempPointer2 = pointer2.next

        pointer1.next = pointer2
        pointer2.next = tempPointer

        pointer1 = tempPointer
        pointer2 = tempPointer2
    }

    middle.next = null
}