package hashtable.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    /***
     * Method 1: hashset, hashset does not have duplication
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set storeMap = new HashSet<>();
        while(head!=null){
            if(storeMap.contains(head)){
                return true;
            }
            storeMap.add(head);
            head = head.next;
        }
        return false;
    }

    /***
     * Method 2: Race. Fast and slow pointers. Fast pointer will catch up.
     * @param head
     * @return
     */
    public boolean hasCyclePointer(ListNode head) {

        if(head==null || head.next==null){
            return false;
        }
        ListNode fastPointer=head;
        ListNode slowPointer=head;
        //fast pointer will catch up
        while(fastPointer!=null && fastPointer.next!=null){
            //run
            fastPointer=fastPointer.next.next;
            slowPointer=slowPointer.next;
            //fastPointer will always be front of the slowPointer, so we just need to check fastPointer.
            if(fastPointer==slowPointer)
                return true;
        }
        return false;
    }

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
