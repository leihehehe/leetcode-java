package design;

class MyCircularDeque1 {
    private int[] deque;
    private int capacity;
    private int head,tail;
    public MyCircularDeque1(int k) {
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
class MyCircularDeque2 {
    private int[] deque;
    private int size;
    private int head;
    private int tail;
    private int capacity;
    public MyCircularDeque2(int k) {
        deque = new int[k];
        capacity = k;
        head = 0;
        tail = 0;
        size = 0;
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        head = head==0?capacity-1:head-1;
        deque[head] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        deque[tail] = value;
        tail = (tail + 1) % capacity;
        size++;
        return true;

    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        head = (head+1)%capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        tail = tail==0? capacity - 1:tail-1;
        size--;
        return true;
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return deque[head];
    }

    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return tail==0?deque[capacity-1]:deque[tail-1];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */