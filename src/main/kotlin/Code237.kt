fun main() {
    deleteNode(buildListNode(4, 5, 6, 7).next)
}

fun deleteNode(node: ListNode?) {
    node!!

    node.`val` = node.next!!.`val`
    node.`val` = node.next!!.`val`
}