fun main(args: Array<String>) {
    println(mergeTwoLists(buildListNode(1, 2, 4), buildListNode(1, 3, 4)))
}

private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    l1 ?: return l2
    l2 ?: return l1

    var l1: ListNode? = l1
    var l2: ListNode? = l2

    val root = ListNode(
        if (l1!!.`val` <= l2!!.`val`) {
            val value = l1.`val`
            l1 = l1.next
            value
        } else {
            val value = l2.`val`
            l2 = l2.next
            value
        }
    )


    var current = root

    while (l1 != null && l2 != null) {
        current = ListNode(
            if (l1.`val` <= l2.`val`) {
                l1.`val`.also {
                    l1 = l1!!.next
                }
            } else {
                l2.`val`.also {
                    l2 = l2!!.next
                }
            }
        ).also {
            current.next = it
        }
    }

    while (l1 != null) {
        current = ListNode(
            l1!!.`val`.also {
                l1 = l1!!.next
            }
        ).also {
            current.next = it
        }
    }

    while (l2 != null) {
        current = ListNode(
            l2!!.`val`.also {
                l2 = l2!!.next
            }
        ).also {
            current.next = it
        }
    }

    return root
}