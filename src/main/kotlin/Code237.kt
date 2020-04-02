fun main() {
    deleteNode(buildListNode(4, 5, 6, 7).next)
}

private fun deleteNode(node: ListNode?) {
    node!!

    node.`val` = node.next!!.`val`
    node.`val` = node.next!!.`val`
}