package linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 1836
 */
public class RemoveDuplicatesFromAnUnsortedLinkedList {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode p = head;
        Map<Integer,Integer> map = new HashMap<>();
        while(p!=null){
            if(map.containsKey(p.val)){
                map.put(p.val,map.get(p.val)+1);
            }else{
                map.put(p.val,1);
            }
            p = p.next;
        }
        ListNode prev = dummyNode;
        p = head;
        while(p!=null){
            if(map.get(p.val)==1){
                prev.next = p;
                prev = prev.next;
            }
            p=p.next;
        }
        prev.next=null;
        return dummyNode.next;
    }
}
