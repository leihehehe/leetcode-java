package linkedList;

/***
 * Leetcode 86
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        ListNode largerLinkedList = new ListNode(-1);
        ListNode large = largerLinkedList;
        ListNode smallerLinkedList = new ListNode(-1);
        ListNode small = smallerLinkedList;

        while(cur!=null){
            if(cur.val<x){
                small.next=cur;
                small=small.next;
            }else{
                large.next=cur;
                large=large.next;
            }
            cur=cur.next;
        }
        large.next=null;
        small.next=largerLinkedList.next;
        return smallerLinkedList.next;
    }
}
