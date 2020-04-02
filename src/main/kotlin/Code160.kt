fun main(args: Array<String>) {
//    val cross = buildListNode(3, 2, 4)
    val left = buildListNode(6, 7)
    val right = buildListNode(1)

//    left.next!!.next = cross
//    right.next = cross

    print(getIntersectionNode(left, right))
}

private fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    headA ?: return null
    headB ?: return null

    var l1: ListNode? = headA
    var l2: ListNode? = headB

    while (l1 != l2) {
        l1 = if (l1 == null) {
            headB
        } else {
            l1.next
        }

        l2 = if (l2 == null) {
            headA
        } else {
            l2.next
        }
    }

    return l1
}