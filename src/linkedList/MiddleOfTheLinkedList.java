package linkedList;

/***
 * Leetcode 876
 */
public class MiddleOfTheLinkedList {
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
        ListNode quick = head;
        ListNode slow = head;
        while(quick!=null && quick.next!=null&&quick.next.next!=null){
            slow = slow.next;
            quick=quick.next.next;
        }
        return slow;
    }

}
