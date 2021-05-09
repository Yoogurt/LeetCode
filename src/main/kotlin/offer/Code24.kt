package offer

import ListNode
import buildListNode

fun main() {
    println(reverseList(buildListNode(1, 2, 3, 4, 5)))
}

private fun reverseList(head: ListNode?): ListNode? {
    head ?: return head
    if (head.next == null) {
        return head
    }

    val result = reverseList(head.next)
    head.next?.next = head
    head.next = null

    return result
}