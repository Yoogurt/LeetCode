fun main() {
    println(isPalindrome(buildListNode(1, 2, 2, 1)))
}

var remember: ListNode? = null

private fun isPalindrome(head: ListNode?): Boolean {
    remember = head

    return check(head)
}

private fun check(node: ListNode?): Boolean {
    node ?: return true

    return if (!check(node.next) || remember?.`val` != node.`val`) {
        false
    } else {
        remember = remember?.next
        true
    }
}