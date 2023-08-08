package random;

import linkedList.ListNode;

import java.util.Random;

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

/**
 * 蓄水池抽样算法
 */
class LinkedListRandomNode {
    ListNode head;
    Random random;
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int res = 0;
        ListNode p = head;
        int i = 0;
        while(p!=null){
            i++;
            //[0,i) -> i is excluded
            int r = random.nextInt(i);
            //P = 1/i
            if(r==0){
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */