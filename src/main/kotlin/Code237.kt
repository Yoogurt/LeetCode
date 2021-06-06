fun main() {
    val list = buildListNode(4, 5, 6, 7)
    deleteNode(list.next)
    print(list)
}

private fun deleteNode(node: ListNode?) {
    node!!

    val next = node.next!!

    node.`val` = next.`val`
    node.next = next.next
}