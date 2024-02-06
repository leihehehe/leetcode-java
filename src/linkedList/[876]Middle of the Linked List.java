package linkedList;

/***
 * Leetcode 876
 */
class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while(quick!=null && quick.next!=null){
            slow = slow.next;
            quick=quick.next.next;
        }
        return slow;
    }
    public ListNode middleNodeBefore(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode quick = dummyNode;
        ListNode slow = dummyNode;
        while(quick!=null && quick.next!=null){
            slow = slow.next;
            quick=quick.next.next;
        }
        return slow;
    }
    public ListNode middleNodeBefore2(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while(quick!=null && quick.next!=null&&quick.next.next!=null){
            slow = slow.next;
            quick=quick.next.next;
        }
        return slow;
    }

}
