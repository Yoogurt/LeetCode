fun main(args: Array<String>) {
    println(mergeKLists(arrayOf(null , buildListNode(1))))
}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val list = lists.filterNotNull().toMutableList()

    while (list.size > 1) {
        list += mergeListNode(list.removeAt(0), list.removeAt(0))
    }

    return list.firstOrNull()
}

private fun mergeListNode(first: ListNode, second: ListNode): ListNode {
    var firstScanNode: ListNode? = first
    var secondScanNode: ListNode? = second

    val head = if (firstScanNode!!.`val` <= secondScanNode!!.`val`) {
        val tempNode = firstScanNode
        firstScanNode = firstScanNode.next
        tempNode
    } else {
        val tempNode = secondScanNode
        secondScanNode = secondScanNode.next
        tempNode
    }

    var currentNode = head

    while (firstScanNode != null && secondScanNode != null) {
        currentNode.next = if (firstScanNode.`val` <= secondScanNode.`val`) {
            val tempNode = firstScanNode
            firstScanNode = firstScanNode.next
            tempNode
        } else {
            val tempNode = secondScanNode
            secondScanNode = secondScanNode.next
            tempNode
        }

        currentNode = currentNode.next!!
    }

    while (firstScanNode != null) {
        currentNode.next = firstScanNode
        firstScanNode = firstScanNode.next
        currentNode = currentNode.next!!
    }

    while (secondScanNode != null) {
        currentNode.next = secondScanNode
        secondScanNode = secondScanNode.next
        currentNode = currentNode.next!!
    }

    return head
}