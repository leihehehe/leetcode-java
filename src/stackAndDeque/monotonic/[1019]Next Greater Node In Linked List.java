package stackAndDeque.monotonic;
//leetcode submit region begin(Prohibit modification and deletion)

import linkedList.ListNode;

import java.util.ArrayDeque;

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
class NextLargerNodes {
    class Pair{
        int index;
        int val;
        public Pair(int index, int val){
            this.index = index;
            this.val = val;
        }
    }
    public int[] nextLargerNodes(ListNode head) {
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        ListNode cur = head;
        int n = 0;
        while(cur!=null){
            n++;
            cur = cur.next;
        }
        int[] res = new int[n];
        cur = head;
        int curIndex = 0;
        while(cur!=null){
            while(!stack.isEmpty() && stack.peek().val<cur.val){
                res[stack.pop().index] = cur.val;
            }
            stack.push(new Pair(curIndex++,cur.val));
            cur = cur.next;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
