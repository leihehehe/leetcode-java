package linkedList;
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
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        while(l1!=null || l2!=null || carry>0){
            int val1 = l1!=null?l1.val:0;
            int val2 = l2!=null?l2.val:0;
            int sum = val1+val2+carry;
            int num = sum%10;
            carry = sum/10;

            cur.next = new ListNode(num);
            cur = cur.next;
            l1 = l1!=null?l1.next:l1;
            l2 = l2!=null?l2.next:l2;
        }
        return dummyNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
