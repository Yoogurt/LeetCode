public class Test {
    public static void main(String[] args) {
        System.out.println(deleteDuplication(NodeKt.buildListNode(1, 2, 3, 3, 4, 4, 5)));
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode previousVisitedNode = pHead;
        ListNode currentVisitNode = pHead.next;

        while (pHead != null && currentVisitNode != null && previousVisitedNode.val == currentVisitNode.val) {
            pHead = currentVisitNode.next;
            previousVisitedNode = pHead;
            currentVisitNode = pHead.next;
        }

        if (pHead == null) {
            return null;
        }

        ListNode lastDiffenceNode = pHead;
        previousVisitedNode = pHead.next;
        currentVisitNode = previousVisitedNode.next;

        for (; currentVisitNode != null; currentVisitNode = currentVisitNode.next) {
            if (previousVisitedNode.val == currentVisitNode.val) {
                lastDiffenceNode.next = null;
            } else {
                lastDiffenceNode.next = currentVisitNode;
                lastDiffenceNode = currentVisitNode;
                previousVisitedNode = currentVisitNode;
            }
        }

        return pHead;
    }
}
