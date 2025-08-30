import kotlin.jvm.internal.Ref

fun main() {
    println(isPalindrome(buildListNode(1, 2,  3, 2, 1)))
}

private fun isPalindrome(head: ListNode?): Boolean {
    val headRef = Ref.ObjectRef<ListNode>()
    headRef.element = head
    return visit(headRef, head)
}

private fun visit(head: Ref.ObjectRef<ListNode>, current: ListNode?): Boolean {
    current ?: return true

    if (!visit(head, current.next)) {
        return false
    }

    val result = head.element.`val` == current.`val`
    head.element = head.element.next
    return result
}