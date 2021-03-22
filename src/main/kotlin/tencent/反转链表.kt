package tencent

import ListNode
import buildListNode

fun main() {
    println(reverseList(buildListNode(1, 2, 3, 4, 5, 6)))
}

fun reverseList(head: ListNode?): ListNode? {
    head?.next ?: return head

    val result = reverseList(head.next)

    head.next?.next = head
    head.next = null

    return result
}