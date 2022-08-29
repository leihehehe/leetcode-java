package priorityQueue;

import linkedList.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedList {
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
}
