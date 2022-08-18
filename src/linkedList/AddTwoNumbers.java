package linkedList;

/***
 * Leetcode 2
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        while(l1!=null||l2!=null){
            int value1 = l1==null?0:l1.val;
            int value2 = l2==null?0:l2.val;
            int sum = value1+value2+carry;
            carry=0;
            if(sum>=10){
                carry++;
                sum = sum-10;
            }
            dummyNode.next = new ListNode(sum);
            dummyNode = dummyNode.next;
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }
        if(carry>0) dummyNode.next=new ListNode(carry);
        return res.next;
    }
}
