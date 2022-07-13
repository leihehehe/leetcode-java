package linkedList;

/***
 * leetcode 92
 */
public class ReverseLinkedListII {
    public ListNode successor = null;

    /***
     * Method 1: recursion
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==1){
            return reverseN(head,right);
        }
        head.next = reverseBetween(head.next,left-1,right-1);
        return head;
    }
    public ListNode reverseN(ListNode head, int n){
        if(n==1){
            successor=head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next,n-1);
        head.next.next = head;
        head.next = successor;
        return newHead;
    }

    /***
     * Method 2: Iteration
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetweenMethod2(ListNode head, int left, int right) {
        //1->2->3->4
        //1->3->2->4
        //left-1(pre) -> right
        //left->right+1(suc)
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for(int i =0;i<left-1;i++){
            pre = pre.next;
        }
        ListNode rightNode = pre;
        for(int i = 0;i<right-left+1;i++){
            rightNode = rightNode.next;
        }

        ListNode leftNode = pre.next;
        ListNode succ = rightNode.next;
        pre.next=null;
        rightNode.next=null;
        ListNode newHead= reverseLinkedList(leftNode);
        pre.next = newHead;
        leftNode.next = succ;
        return dummyNode.next;
    }
    public ListNode reverseLinkedList(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        while(cur!=null){
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }
}
