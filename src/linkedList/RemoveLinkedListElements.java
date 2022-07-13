package linkedList;

/***
 * Leetcode 203
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while(cur.next!=null){
            if(cur.next.val==val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }
}
