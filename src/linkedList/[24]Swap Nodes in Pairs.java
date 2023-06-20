package linkedList;
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
class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while(cur.next!=null && cur.next.next !=null){
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            node1.next = node2.next;
            node2.next = node1;
            cur.next = node2;
            cur = node1;
        }
        return dummyNode.next;

    }
    public ListNode swapPairsIterative2(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode res = head;
        while(cur!=null && cur.next!=null){
            ListNode next = cur.next.next;
            ListNode newHead = cur.next;
            if(res==head)
                res = newHead;
            if(prev!=null)
                prev.next = newHead;
            cur.next.next = cur;
            cur.next = next;
            prev = cur;
            cur = next;
        }
        return res;
    }
    public ListNode swapPairsRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
