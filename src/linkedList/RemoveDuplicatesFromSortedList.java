package linkedList;

/***
 * Leetcode 83
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next=head;
        ListNode cur = head;
        ListNode prev = dummyNode;
        while(cur!=null){
            //last duplicate
            while(cur.next!=null && cur.next.val==cur.val){
                cur=cur.next;
            }
            prev.next=cur;
            prev=cur;
            cur=cur.next;
        }
        return dummyNode.next;
    }
}
