package sort;
//leetcode submit region begin(Prohibit modification and deletion)

import linkedList.ListNode;

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
class SortList {
    public ListNode sortList(ListNode head) {
        return merge(head);
    }

    public ListNode merge(ListNode head){
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode middleNode = findMiddle(head);
        ListNode right = middleNode.next;
        middleNode.next = null;
        ListNode left = head;
        return mergeTwoLists(merge(left),merge(right));
    }
    public ListNode findMiddle(ListNode head){
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next=head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergeTwoLists(ListNode p, ListNode q){
        if(p==null){
            return q;
        }
        if(q==null){
            return p;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        while(p!=null && q!=null){
            if(p.val<q.val){
                cur.next = p;
                ListNode next = p.next;
                p.next = null;
                p = next;
            }else{
                cur.next = q;
                ListNode next = q.next;
                q.next = null;
                q = next;
            }
            cur = cur.next;
        }
        if(p!=null){
            cur.next = p;
        }
        if(q!=null){
            cur.next = q;
            q = q.next;
        }
        return dummyNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
