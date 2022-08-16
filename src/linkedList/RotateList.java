package linkedList;

/***
 * Leetcode 61
 * Time complexity O(n)
 * Space complexity O(1)
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null|| k == 0)  return head;
        int n = 1;
        ListNode tail = head;
        while(tail.next!=null){
            tail=tail.next;
            n++;
        }
        k=k%n;
        ListNode p = head;
        for(int i = 0; i < n - k - 1; i++)  p = p.next;   //n-k-1th node
        tail.next = head;
        head = p.next;
        p.next = null;
        return head;
    }
}
