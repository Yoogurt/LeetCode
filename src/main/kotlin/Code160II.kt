fun main() {
    val left = buildListNode(6, 7)
    val right = buildListNode(1, 8, 9, 10)

//    left.next?.next = right.next?.next?.next
    print(getIntersectionNode(left, right))
}

private fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var scanA: ListNode? = headA ?: return null
    var scanB: ListNode? = headB ?: return null

    var scanARepeat = false
    var scanBRepeat = false

    while (scanA != scanB) {
        scanA = scanA?.next
        if (scanA == null) {
            if (!scanARepeat) {
                scanA = headB
                scanARepeat = true
            } else return null
        }

        scanB = scanB?.next
        if (scanB == null) {
            if (!scanBRepeat) {
                scanB = headA
                scanBRepeat = true
            } else return null
        }
    }

    return scanA
}