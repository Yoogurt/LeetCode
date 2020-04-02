fun main() {
    println(swapPairs(buildListNode(1, 2, 3, 4)))
}

private fun swapPairs(head: ListNode?): ListNode? {
    var current = head ?: return null

    var headToLink: ListNode? = null

    var next = current.next
    var result: ListNode? = null


    while (next != null) {
        val nextToRemember = next.next
        headToLink = swapWithNextNode(current, headToLink)

        result = result ?: next

        current = nextToRemember ?: return result
        next = nextToRemember.next
    }

    return result
}

private fun swapWithNextNode(node: ListNode, headNeedToLink: ListNode?): ListNode {
    val nextNode = node.next!!

    nextNode.next = node
    node.next = null
    headNeedToLink?.next = nextNode

    return node
}

