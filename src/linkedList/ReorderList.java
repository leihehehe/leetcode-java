package linkedList;

import java.util.ArrayList;

/***
 * Leetcode 143
 */
public class ReorderList {
    /***
     * Method 1: linear list
     * O(N),O(N)
     * @param head
     */
    public void reorderListLinear(ListNode head) {
        ListNode cur = head;
        ArrayList<ListNode> nodes = new ArrayList<>();
        while(cur!=null){
            nodes.add(cur);
            cur=cur.next;
        }
        int i=0,j=nodes.size()-1;
        while(i<j){
            nodes.get(i).next=nodes.get(j);
            i++;
            if(i>=j) break;
            nodes.get(j).next=nodes.get(i);
            j--;
        }
        nodes.get(i).next=null;

    }

    /***
     * Method 2:
     * Step 1: Find middle of the linked list
     * Step 2: Reserve middle Linked list
     * Step 3: Merge two linked lists
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head==null)
            return;
        //get the middle node
        ListNode midNode = findMidNode(head);
        ListNode head2 = midNode.next;
        //you have to break it into two linked list, otherwise head1 will have the complete list..
        midNode.next = null;
        head2 =reverseLinkedList(head2);
        ListNode head1 = head;
        mergelist(head1,head2);

    }
    public ListNode findMidNode(ListNode head){
        ListNode slow = head;
        ListNode quick = head;
        while(quick!=null && quick.next!=null && quick.next.next!=null){
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }
    public ListNode reverseLinkedList(ListNode head){
        if(head==null || head.next ==null) return head;
        ListNode newHead =reverseLinkedList(head.next);
        //1->2->3->4
        //1<-(2<-3<-4) newHead = 4
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public void mergelist(ListNode head1, ListNode head2){
        while(head1!=null&&head2!=null){
            ListNode head1NextNode=head1.next;
            ListNode head2NextNode=head2.next;
            head1.next = head2;
            head1 = head1NextNode;
            head2.next=head1;
            head2= head2NextNode;
        }
    }
}
