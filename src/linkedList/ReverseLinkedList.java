package linkedList;

/***
 * LeetCode 206
 */
public class ReverseLinkedList {
    public ListNode reverseListRecursion(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode newHead = reverseListRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public ListNode reverseListIteration(ListNode head) {
        //1->2->3
        //null <- 1 <- 2<- 3
        ListNode prev = null;
        ListNode cur = head;

        while(cur!=null){
            ListNode nextNode = cur.next;
            cur.next =prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }
}
