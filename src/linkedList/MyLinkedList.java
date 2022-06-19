package linkedList;

public class MyLinkedList {
    //dummy node
    private ListNode dummy = new ListNode(-1);

    public void add(int location, int value){
        ListNode newNode = new ListNode(value);
        ListNode preNode= dummy;
        for(int i =0;i<location;i++){
            preNode=preNode.next;
        }
        newNode.next=preNode.next;
        preNode.next=newNode;
    }

    public int remove(int location){
            ListNode result;
            ListNode preNode = dummy;
            for(int i=0;i<location;i++){
                preNode=preNode.next;
            }
            result=preNode.next;
            preNode.next=preNode.next.next;

        //print the deleted value
        return result.val;
    }

    public int get(int location){
        ListNode node =dummy.next;
        for(int i=0;i<location;i++){
                node=node.next;
         }
        return node.val;
    }

    public void set(int location, int value){
        ListNode node =dummy.next;
        for(int i=0;i<location;i++){
            node=node.next;
        }
        node.val=value;
    }
}
