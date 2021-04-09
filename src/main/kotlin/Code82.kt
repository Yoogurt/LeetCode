fun main() {
    println(deleteDuplicates(buildListNode(-1, 1, 2, 3, 4, 5, 6, 6)))
}

private fun deleteDuplicates(head: ListNode?): ListNode? {
    var head: ListNode? = head ?: return null

    var currentValue = head?.`val` ?: return null
    while (true) {
        if (currentValue == head?.next?.`val`) {
            head = head.next
        }
    }

    var current = head?.next
    while (current != null) {
        if (current.`val` == current.next?.`val`) {
            current.next = current.next?.next
        } else {
            current = current.next
        }
    }

    return head
}