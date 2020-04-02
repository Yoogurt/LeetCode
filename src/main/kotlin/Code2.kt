fun main(vararg args: String) {
    val first = buildListNode(2, 4, 9, 9)
    val second = buildListNode(5, 6, 4)

    print(addTwoNumbers(first, second))
}

private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    l1 ?: return l2
    l2 ?: return l1

    var carry = 0

    var l1: ListNode? = l1
    var l2: ListNode? = l2

    var head: ListNode? = null
    var current: ListNode? = null

    while (l1 != null && l2 != null) {
        var value = l1.`val` + l2.`val` + carry
        carry = value / 10
        value %= 10

        current = ListNode(value).also {
            current?.next = it
        }
        head = head ?: current

        l1 = l1.next
        l2 = l2.next
    }

    while (l1 != null) {
        var value = l1.`val` + carry
        carry = value / 10
        value %= 10

        current = ListNode(value).also {
            current?.next = it
        }

        l1 = l1.next
    }

    while (l2 != null) {
        var value = l2.`val` + carry
        carry = value / 10
        value %= 10

        current = ListNode(value).also {
            current?.next = it
        }

        l2 = l2.next
    }

    if (carry > 0) {
        current!!.next = ListNode(carry)
    }

    return head
}