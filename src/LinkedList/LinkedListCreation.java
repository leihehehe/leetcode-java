package LinkedList;

import java.util.LinkedList;

public class LinkedListCreation {
    public static void createLinkedList(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        ListNode curNode=node1;
        check(curNode);
        while (curNode!=null){
            System.out.println(curNode.val);
            curNode=curNode.next;
        }
    }
    public static void check(ListNode head){
        head=head.next;
        System.out.println(head);
    }


    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(0,1);
        myLinkedList.add(1,3);
        myLinkedList.add(2,4);
        myLinkedList.add(3,5);
        System.out.println(myLinkedList);
        for(int i=0;i<4;i++){
            System.out.print(myLinkedList.get(i)+" ");
        }
    }

}
