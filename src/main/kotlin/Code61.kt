package main.kotlin

import ListNode
import buildListNode

fun main(args: Array<String>) {
    println(rotateRight(buildListNode(1, 2), 1))
}

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (k <= 0 || head == null) {
        return head
    }

    var fastNode = head

    repeat(k) {
        fastNode = fastNode?.next ?: head
    }

    var fastNodeNext: ListNode? = fastNode!!.next ?: head
    val newHead = fastNodeNext

    if (head !== fastNode) {
        while (fastNodeNext?.next != null) {
            fastNodeNext = fastNodeNext.next
        }

        fastNodeNext!!.next = head
        fastNode!!.next = null
    } else {
        return head
    }

    return newHead
}