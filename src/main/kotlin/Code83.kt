fun main() {
    println(deleteDuplicates(buildListNode(1,1,1)))
}

private fun deleteDuplicates(head: ListNode?): ListNode? {
    head ?: return null

    var scan = head

    while (scan != null) {
        if (scan.`val` == scan.next?.`val`) scan.next = scan.next?.next else scan = scan.next
    }

    return head
}