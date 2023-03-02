package linkedList;

/**
 * Offer 22
 */
public class TheKthNodeFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p1 = head, p2 = head;
        for(int i =0;i<k;i++){
            p1 = p1.next;
        }
        while(p1!=null){
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }
}
