package design;

/***
 * Leetcode 622
 */
class MyCircularQueue {
    int[] queue;
    int head;
    int tail;
    int capacity;
    //loop invariant: [head,tail) is all the valid queue.
    public MyCircularQueue(int k) {
        capacity= k+1;
        queue=new int[capacity];
        head=tail=0;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        queue[tail]=value;
        tail=(tail+1)%capacity;
        return true;
    }

    public boolean deQueue() {
        //first in first out -> change head
        if(isEmpty()) return false;
        head = (head + 1) % capacity;

        return true;
    }

    public int Front() {
        if(isEmpty()) return -1;
        return queue[head];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        return queue[(tail - 1 + capacity) % capacity];
        // = (tail-1)%capacity -> +capacity is used to avoid exceeding the array bound.
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return ((tail + 1) % capacity) == head;
    }
}
class MyCircularQueue2 {
    private int capacity;
    private int[] buffer;
    private int head;
    private int tail;
    private int size;
    //[head,tail]
    public MyCircularQueue2(int k) {
        capacity = k;
        buffer = new int[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        buffer[tail] = value;
        tail = (tail + 1)%capacity;
        size++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        head = (head + 1)%capacity;
        size--;
        return true;

    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return buffer[head];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return tail==0?buffer[capacity-1]:buffer[tail-1];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}