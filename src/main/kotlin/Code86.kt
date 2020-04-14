fun main(args: Array<String>) {
    println(partition(buildListNode(4, 1, 3), 3))
}

private fun partition(head: ListNode?, x: Int): ListNode? {
    var smallerHead: ListNode? = null
    var biggerHead: ListNode? = null

    var smallerTail: ListNode? = null
    var biggerTail: ListNode? = null

    var scanNode = head
    while (scanNode != null) {
        val nextNode = scanNode.next

        try {
            if (scanNode.`val` < x) {
                if (smallerHead == null) {
                    smallerHead = scanNode
                    smallerTail = smallerHead
                    smallerTail.next = null
                    continue
                }

                smallerTail!!.next = scanNode
                smallerTail = scanNode
                smallerTail.next = null
            } else {
                if (biggerHead == null) {
                    biggerHead = scanNode
                    biggerTail = biggerHead
                    biggerTail.next = null
                    continue
                }

                biggerTail!!.next = scanNode
                biggerTail = scanNode
                biggerTail.next = null
            }
        } finally {
            scanNode = nextNode
        }
    }

    smallerHead ?: return biggerHead
    biggerHead ?: return smallerHead

    smallerTail!!.next = biggerHead
    return smallerHead
}