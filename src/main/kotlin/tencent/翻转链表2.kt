package tencent

import ListNode
import buildListNode

fun main() {
    val listNode = buildListNode(1,2,3,4,5)
    println(reverseList2(listNode))
}

fun reverseList2(node: ListNode?) : ListNode? {
    node?.next ?: return node

    val tail = reverseList2(node.next)
    node.next?.next = node;
    node.next = null

    return tail
}