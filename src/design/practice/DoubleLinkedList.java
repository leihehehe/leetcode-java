package design.practice;

public class DoubleLinkedList {
    private Node head, tail;
    private int size;

    public DoubleLinkedList() {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next=tail;
        tail.prev = head;
        size = 0;
    }
    //head<->tail
    //head<->x<->tail
    public void addLast(Node x){
        x.prev = tail.prev;
        x.next=tail;
        tail.prev.next = x;
        tail.prev = x;
        size ++;
    }
    public void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }
    //remove the first node and return it
    public Node removeFirst(){
        //no node
        if(head.next==tail) return null;
        Node first = head.next;
        remove(first);
        return first;
    }

    public int size(){
        return size;
    }

}
