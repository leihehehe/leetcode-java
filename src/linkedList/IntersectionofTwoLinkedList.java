package linkedList;

import java.util.HashSet;
import java.util.Set;

/***
 * Leetcode 160
 */
public class IntersectionofTwoLinkedList {

    /***
     * Method 1: Hashset
     * Time complexity: O(n)
     * Space complexity: O(n) -> not meet the requirement
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> sets = new HashSet<>();
        ListNode cur = headA;
        while(cur!=null){
            sets.add(cur);
            cur = cur.next;
        }
        cur = headB;
        while(cur!=null){
            if(sets.contains(cur)) return cur;
            cur=cur.next;
        }
        return null;
    }
    /**
     * Method 2: make the longer linked list and the shorter linked list start at the same place.
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeMethod2(ListNode headA, ListNode headB) {
        int n1 = getLenOfLinkedList(headA);
        int n2 = getLenOfLinkedList(headB);
        int diff = Math.abs(n1-n2);
        ListNode longerList=null;
        ListNode shorterList=null;
        if(n1>n2){
            longerList=headA;
            shorterList=headB;
        }else{
            longerList = headB;
            shorterList=headA;
        }
        for(int i =0;i<diff;i++){
            longerList=longerList.next;
        }
        while(longerList!=null){
            if(longerList==shorterList) return longerList;
            longerList=longerList.next;
            shorterList=shorterList.next;
        }
        return null;
    }

    public int getLenOfLinkedList(ListNode cur){
        int n=0;
        while(cur!=null){
            n++;
            cur= cur.next;
        }
        return n;
    }

    /***
     * Method 3: double pointers
     * a+b+c
     * b+a+c
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeMethod3(ListNode headA, ListNode headB) {
        ListNode listA = headA;
        ListNode listB = headB;
        while(listA!=listB){
            listA = listA==null? headB : listA.next;
            listB = listB==null? headA : listB.next;
        }
        return listA;
    }
}
