fun main() {
    println(swapPairs(buildListNode(1,2)))
}

private fun swapPairs(head: ListNode?): ListNode? {
    var current = head ?: return null

    var headToLink: ListNode? = null

    var next :ListNode? = current.next ?: return head
    var result: ListNode? = null


    while (next != null) {
        val nextToRemember = next.next

        headToLink = swapWithNextNode(current, headToLink)
        headToLink.next = nextToRemember

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

