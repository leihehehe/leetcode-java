package stackAndDeque;

public class DesignCircularDeque {
    private int[] deque;
    private int capacity;
    private int head,tail;
    public DesignCircularDeque(int k) {
        capacity = k+1;
        deque = new int[capacity];
        head=tail=0;
    }
    //loop invarient: [head,tail) -> valid
    public boolean insertFront(int value) {
        if(isFull()) return false;
        head= (head-1+capacity) % capacity;
        deque[head]=value;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()) return false;
        deque[tail]=value;
        tail= (tail+1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()) return false;
        head= (head+1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()) return false;
        tail= (tail-1+capacity) % capacity;
        return true;
    }

    public int getFront() {
        if(isEmpty()) return -1;
        return deque[head];
    }

    public int getRear() {
        if(isEmpty()) return -1;
        return deque[(tail-1+capacity)%capacity];
    }

    public boolean isEmpty() {
        return tail==head;
    }

    public boolean isFull() {
        return (tail+1)%capacity == head;
    }
}
