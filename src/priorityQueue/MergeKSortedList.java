package priorityQueue;

import linkedList.ListNode;

import java.util.PriorityQueue;

/**
 * Leetcode 23
 */
public class MergeKSortedList {
    /**
     * Method 1 - creating a Comparable class
     */
    public class ListComparable implements Comparable<ListComparable>{
        ListNode cur;
        int val;
        public ListComparable(ListNode cur){
            this.cur = cur;
            this.val = cur.val;
        }
        @Override
        public int compareTo(ListComparable list){
            if(this.val > list.val){
                return 1;
            }else if(this.val<list.val) return -1;
            else return 0;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        PriorityQueue<ListComparable> queue = new PriorityQueue<>();
        for(ListNode list: lists){
            if(list ==null) continue;
            queue.offer(new ListComparable(list));
        }
        while(!queue.isEmpty()){
            ListNode cur = queue.poll().cur;
            dummyNode.next = cur;
            dummyNode=dummyNode.next;
            if(cur.next!=null){
                queue.offer(new ListComparable(cur.next));
            }
        }
        return res.next;
    }

    /**
     * Method 2
     */

    public ListNode mergeKListsMethod2(ListNode[] lists) {
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((list1,list2)->list1.val-list2.val);
        for(ListNode list: lists){
            if(list==null) continue;
            queue.offer(list);
        }
        while(!queue.isEmpty()){
            ListNode cur = queue.poll();
            dummyNode.next = cur;
            if(cur.next!=null){
                queue.offer(cur.next);
            }
            dummyNode = dummyNode.next;
        }
        return res.next;
    }
}
