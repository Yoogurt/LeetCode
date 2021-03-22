fun main(args: Array<String>) {

}

private fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
    head ?: return null

    var nodeToReverse = head

    repeat(m) {
        nodeToReverse = nodeToReverse?.next
    }

    if (nodeToReverse == head) {
        return reverseList(head, n - m)
    } else {
        nodeToReverse
        return head
    }
}

private fun reverseList(head: ListNode?, count: Int): ListNode? {
    head?.next ?: return head

    if (count <= 0) {
        return head
    }

    val result = reverseList(head.next, count - 1)
    head.next?.next = head.next
    head.next = null

    return result
}