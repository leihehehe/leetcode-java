package linkedList;

import java.util.ArrayList;

/***
 * Leetcode 19
 */
public class RemoveNthNodeFromEndofList {
    /**
     * Method 1: ArrayList
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ArrayList<ListNode> nodes = new ArrayList<>();
        while(cur!=null){
            nodes.add(cur);
            cur = cur.next;
        }
        int sz = nodes.size();

        int beforeIndex = sz-n-1;
        if(beforeIndex<0) return head.next;
        int afterIndex = sz-n+1;
        if(afterIndex>sz-1) nodes.get(beforeIndex).next=null;
        else{
            nodes.get(beforeIndex).next=nodes.get(afterIndex);
        }
        return head;
    }

    /***
     * Method 2: dummy node
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndMethod2(ListNode head, int n) {
        ListNode cur = head;
        int sz = 0;
        while(cur!=null){
            cur = cur.next;
            sz++;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next=head;
        ListNode beforeNode =dummyNode;
        int beforeIndex = sz-n;
        for(int i =0;i<beforeIndex;i++){
            beforeNode=beforeNode.next;
        }
        ListNode afterNode = beforeNode.next.next;
        beforeNode.next=afterNode;
        return dummyNode.next;
    }

    /***
     * Method 3: fast and slow pointers
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndMethod3(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next=head;
        ListNode slow=dummyNode,fast= head;
        for(int i =0;i<n;i++){
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }

}
