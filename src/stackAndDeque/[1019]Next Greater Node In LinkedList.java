package stackAndDeque;

import linkedList.ListNode;

import java.util.*;

/***
 * Leetcode 1019
 */
class NextGreaterNodeInLinkedList {
    /**
     * method 1
     * @param head
     * @return
     */
    public int[] nextLargerNodes(ListNode head) {
        //decreasing
        Deque<Integer> stack = new ArrayDeque<>();
        ListNode cur = head;
        List<Integer> list = new ArrayList<>();

        while(cur!=null){
            list.add(cur.val);
            cur = cur.next;
        }
        int[] res = new int[list.size()];
        for(int i =0;i<list.size();i++){
            while(!stack.isEmpty() && list.get(stack.peek())<list.get(i)){
                res[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }

    /**
     * method 2
     * @param head
     * @return
     */
    public int[] nextLargerNodesMethod2(ListNode head) {
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
