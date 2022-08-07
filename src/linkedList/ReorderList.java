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
    public void reorderList(ListNode head) {
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
}
