package stackAndDeque;

import linkedList.ListNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/***
 * Leetcode 1019
 */
public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[10000];
        int n =0;
        ListNode cur = head;
        while(cur!=null){
            while(!stack.isEmpty()&&cur.val>stack.peekLast()[0]){
                res[stack.removeLast()[1]]=cur.val;
            }
            stack.addLast(new int[] {cur.val,n});
            cur=cur.next;
            n++;
        }
        return Arrays.copyOf(res,n);
    }
}
