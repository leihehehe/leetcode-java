package linkedList;

/**
 * Leetcode 25
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next= head;
        ListNode prev = dummyNode;
        ListNode last = dummyNode;
        while(last.next!=null){
            //check if we have k nodes, if we do, assign the last
            for(int i =0;i<k;i++){
                last = last.next;
                if(last==null){
                    return dummyNode.next;
                }
            }
            ListNode startNode = prev.next;
            ListNode backupNext = last.next;
            last.next = null;
            ListNode newHead = reverse(startNode);
            prev.next = newHead;
            startNode.next=backupNext;
            prev = startNode;
            last = prev;
        }

        return dummyNode.next;
    }
    public ListNode reverse(ListNode root){
        ListNode prev = null;
        ListNode cur = root;
        while(cur!=null){
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }
}
