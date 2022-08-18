package linkedList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class AddTwoNumbersII {
    /***
     * Method 1: ArrayList
     * Time complexity -> O(max(m,n))
     * Space complexity -> O(m+n)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<ListNode> l1Nodes = new ArrayList<>();
        ArrayList<ListNode> l2Nodes = new ArrayList<>();
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        while(l1!=null){
            l1Nodes.add(l1);
            l1=l1.next;
        }
        while(l2!=null){
            l2Nodes.add(l2);
            l2=l2.next;
        }
        int sz1 = l1Nodes.size();
        int sz2 = l2Nodes.size();
        int i1 = sz1-1;
        int i2 = sz2-1;
        int carry=0;
        while(i1>=0 || i2>=0){
            int value1 = i1<0?0:l1Nodes.get(i1).val;
            int value2 = i2<0?0:l2Nodes.get(i2).val;
            int sum = value1+value2+carry;
            carry=0;
            if(sum>=10){
                carry++;
                sum%=10;
            }
            ListNode newNode = new ListNode(sum);
            newNode.next = dummyNode.next;
            dummyNode.next = newNode;
            i1--;
            i2--;
        }
        if(carry>0){
            ListNode newNode = new ListNode(carry);
            newNode.next = dummyNode.next;
            dummyNode.next = newNode;
        }
        return res.next;

    }

    /***
     * Method 2: Stack
     * Time complexity -> O(max(m,n))
     * Space complexity -> O(m+n)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersMethod2(ListNode l1, ListNode l2) {
        Deque<ListNode> nodes1 = new ArrayDeque<>();
        Deque<ListNode> nodes2 = new ArrayDeque<>();
        while(l1!=null){
            nodes1.push(l1);
            l1=l1.next;
        }
        while(l2!=null){
            nodes2.push(l2);
            l2=l2.next;
        }
        int carry = 0;
        ListNode res = null;
        while(!nodes1.isEmpty()||!nodes2.isEmpty() || carry>0){
            int value1 = nodes1.isEmpty()?0:nodes1.pop().val;
            int value2 = nodes2.isEmpty()?0:nodes2.pop().val;
            int sum = value1+value2+carry;
            carry = 0;
            if(sum>=10){
                carry++;
                sum%=10;
            }
            ListNode curNode=new ListNode(sum);
            curNode.next=res;
            res=curNode;
        }
        return res;
    }
}
