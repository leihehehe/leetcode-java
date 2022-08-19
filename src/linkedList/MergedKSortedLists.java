package linkedList;

/***
 * Leetcode 23
 */
public class MergedKSortedLists {
    /***
     * Method 1: Divide and Conquer -> use recursive method
     * Time complexity: O(kn logk)
     * Space complexity: O(logk)
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = l-(r+l)/2;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode(-1);
        ListNode res =dummyNode;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                dummyNode.next=list1;
                list1=list1.next;
            }else{
                dummyNode.next=list2;
                list2=list2.next;
            }
            dummyNode=dummyNode.next;
        }
        dummyNode.next = list1==null?list2:list1;
        return res.next;
    }
    /***
     * Method 2: a straight-forward way: iterate each linkedlist and merge
     */
    public ListNode mergeKListsMethod2(ListNode[] lists) {
        ListNode newList = null;
        for(ListNode list : lists){
            newList = mergeTwoListsMethod2(newList,list);
        }
        return newList;
    }
    public ListNode mergeTwoListsMethod2(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode(-1);
        ListNode res =dummyNode;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                dummyNode.next=list1;
                list1=list1.next;
            }else{
                dummyNode.next=list2;
                list2=list2.next;
            }
            dummyNode=dummyNode.next;
        }
        dummyNode.next = list1==null?list2:list1;
        return res.next;
    }
}
