package linkedList;

import java.util.ArrayList;

/***
 * Leetcode 234
 */
public class PalindromeLinkedList {
    /**
     * Medthod 1: Linear Linked list
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while(cur!=null){
            nodes.add(cur);
            cur= cur.next;
        }
        for(int i=0,j=nodes.size()-1;i<nodes.size();i++,j--){
            ListNode p1 = nodes.get(i);
            ListNode p2 = nodes.get(j);
            if(p1.val!=p2.val) return false;
        }
        return true;
    }

    /**
     * Method 2: reverse the second half linked list, and use double pointers to compare
     * @param head
     * @return
     */

    public boolean isPalindromeMethod2(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode midBefore = findMidBefore(head);
        ListNode mid = midBefore.next;
        midBefore.next=null;
        ListNode newHead = reserveList(mid);
        while(newHead!=null){
            if(newHead.val!=head.val) return false;
            newHead=newHead.next;
            head=head.next;
        }
        return true;
    }

    public ListNode findMidBefore(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reserveList(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }
}
