package linkedList;

/***
 * Leetcode 83
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * Method 1: traverse
     * @param head
     * @return
     */
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
    /**
     * Double pointer
     * @param head
     * @return
     */
    //invariant [0,p1] only contains unique elements
    public ListNode deleteDuplicatesMethod2(ListNode head) {
        if(head==null) return null;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p2!=null){
            if(p2.val!=p1.val){
                p1.next = p2;
                p1 = p1.next;
            }
            p2 = p2.next;
        }
        p1.next = null;

        return head;
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */




}
