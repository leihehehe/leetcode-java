package linkedList;

/***
 * Leetcode 328
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return head;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode evenBackup = evenHead;//backup for linking oddHead and evenHead
        while(evenHead!=null&&evenHead.next!=null){
            oddHead.next=evenHead.next;
            oddHead=oddHead.next;
            evenHead.next=oddHead.next;
            evenHead=evenHead.next;
        }
        oddHead.next=evenBackup;
        return head;
    }
}
