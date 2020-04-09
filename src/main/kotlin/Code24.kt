fun main() {
    println(swapPairs2(buildListNode(1, 2, 3, 5, 6)))
}

private fun swapPairs(head: ListNode?): ListNode? {
    var current = head ?: return null

    var headToLink: ListNode? = null

    var next: ListNode? = current.next ?: return head
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


private fun swapPairs2(head: ListNode?): ListNode? {
    val fastNode = head?.next?.next
    head?.next ?: return head

    val result = reserveList(head)
    result.next?.next = swapPairs2(fastNode)
    return result
}

private fun reserveList(node: ListNode): ListNode {
    val next = node.next
    next!!.next = node
    node.next = null
    return next
}