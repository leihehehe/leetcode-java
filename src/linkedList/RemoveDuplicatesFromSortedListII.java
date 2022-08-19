package linkedList;

/***
 * Leetcode 82
 */
public class RemoveDuplicatesFromSortedListII {
    /**
     * Method 1: modifying linkedlist
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;
        ListNode pre=dummyNode;
        ListNode cur=head;
        while(cur!=null){
            // go to the last duplicate
            while(cur.next!=null&&cur.next.val==cur.val) cur=cur.next;
            //pre.next==cur means no duplicates were detected in the while loop above
            if(pre.next==cur)  pre=pre.next;
                //otherwise make pre.next = the node after the last duplicate
            else pre.next=cur.next;//we do not move pre, because we are not sure whether the latter cur node is duplicate or not.
            cur=cur.next;
        }
        return dummyNode.next;
    }

    /***
     * Method 2: boolean
     */
    public ListNode deleteDuplicatesMethod2(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        ListNode prev = null;
        boolean duplicate = false;
        while(head!=null){
            //it has previous node recorded
            if(prev!=null && prev.val!=head.val){
                if(duplicate){
                    duplicate = false;
                }else{
                    dummyNode.next=prev;
                    dummyNode=dummyNode.next;
                }
            }
            if(prev!=null && prev.val==head.val) duplicate=true;
            prev = head;
            head = head.next;
        }
        dummyNode.next=duplicate?null:prev;
        return res.next;
    }
}
