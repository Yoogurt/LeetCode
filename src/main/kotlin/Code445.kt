import java.util.*

fun main(args: Array<String>) {
    println(addTwoNumbers(buildListNode(9, 9), buildListNode(1)))
}

private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val node1 = l1.toStack()
    val node2 = l2.toStack()

    val result = Stack<Int>()
    var carry = 0

    while (node1.isNotEmpty() && node2.isNotEmpty()) {
        val currentNodeResult = node1.pop() + node2.pop() + carry
        result += currentNodeResult % 10
        carry = currentNodeResult / 10
    }

    while (node1.isNotEmpty()) {
        val currentNodeResult = node1.pop() + carry
        result += currentNodeResult % 10
        carry = currentNodeResult / 10
    }

    while (node2.isNotEmpty()) {
        val currentNodeResult = node2.pop() + carry
        result += currentNodeResult % 10
        carry = currentNodeResult / 10
    }

    if (carry > 0) {
        result += carry
    }

    return result.buildListNode()
}

private fun ListNode?.toStack(): Stack<Int> {
    val result = Stack<Int>()

    var current = this

    while (current != null) {
        result.push(current.`val`)
        current = current.next
    }

    return result
}

private fun Stack<Int>.buildListNode(): ListNode? {
    if (isEmpty()) {
        return null
    }

    val root = ListNode(pop())

    var currentNode = root

    while (isNotEmpty()) {
        currentNode.next = ListNode(pop())
        currentNode = currentNode.next!!
    }

    return root
}