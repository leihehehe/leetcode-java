package linkedList;

/***
 * Leetcode 21
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prev = new ListNode(-1);
        ListNode res = prev;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                prev.next=list1;
                list1=list1.next;
            }else{
                prev.next = list2;
                list2=list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1==null? list2:list1;
        return res.next;
    }
}
