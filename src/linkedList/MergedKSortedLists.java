package linkedList;

import java.util.PriorityQueue;

/***
 * Leetcode 23
 */
public class MergedKSortedLists {
    /***
     * Method 1: Divide and Conquer -> use recursive method
     * Time complexity: O(kn logk)
     * Space complexity: O(logk)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode[] lists, int l, int r){
        if(l==r) return lists[l];
        if(l>r) return null;
        int mid = l+(r-l)/2;
        return mergeTwoLists(merge(lists,l,mid),merge(lists,mid+1,r));
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode(-1), p = dummyNode;
        ListNode p1 = list1, p2 = list2;
        while(p1!=null && p2!=null){
            if(p1.val<=p2.val){
                p.next=p1;
                p1=p1.next;
            }else{
                p.next = p2;
                p2=p2.next;
            }
            p = p.next;
        }
        if(p1!=null) p.next = p1;
        if(p2!=null) p.next = p2;
        return dummyNode.next;
    }
    /***
     * Method 2: a straight-forward way: iterate each linkedlist and merge
     */
    public ListNode mergeKListsMethod2(ListNode[] lists) {
        ListNode newList = null;
        for(ListNode list : lists){
            newList = mergeTwoListsMethod2(newList,list);
        }
        return newList;
    }
    public ListNode mergeTwoListsMethod2(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode(-1);
        ListNode res =dummyNode;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                dummyNode.next=list1;
                list1=list1.next;
            }else{
                dummyNode.next=list2;
                list2=list2.next;
            }
            dummyNode=dummyNode.next;
        }
        dummyNode.next = list1==null?list2:list1;
        return res.next;
    }

    /**
     * Method 3: priority queue
     * Time complexity: O(n logk)
     * Space complexity: O(k)->priority queue
     * @param lists
     * @return
     */
    public ListNode mergeKListsMethod3(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode dummy = new ListNode(-1), p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length,(a, b)->a.val-b.val);
        for(ListNode head : lists){
            if(head!=null) pq.offer(head);
        }
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            p.next = node;
            if(node.next!=null) pq.offer(node.next);
            p=p.next;
        }
        return dummy.next;
    }
}
