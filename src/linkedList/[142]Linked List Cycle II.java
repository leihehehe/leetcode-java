package linkedList;

import java.util.HashSet;

/***
 * Leetcode 142
 */
class LinkedListCycleII {
    /**
     * Method 1: double pointers
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                ListNode l1= head;
                ListNode l2 = slow;
                while(l1!=l2){
                    l1 = l1.next;
                    l2 = l2.next;
                }
                return l1;
            }
        }
        return null;
    }

    /***
     * Method 2: Hashset
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param head
     * @return
     */
    public ListNode detectCycleMethod2(ListNode head) {
        ListNode cur = head;
        HashSet<ListNode> sets = new HashSet<>();
        while(cur!=null){
            if(sets.contains(cur)) return cur;
            sets.add(cur);
            cur=cur.next;
        }
        return null;
    }
}
