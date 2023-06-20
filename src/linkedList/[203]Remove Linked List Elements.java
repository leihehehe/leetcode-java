package linkedList;
//leetcode submit region begin(Prohibit modification and deletion)
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
class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
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
//leetcode submit region end(Prohibit modification and deletion)
