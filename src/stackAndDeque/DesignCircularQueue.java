package stackAndDeque;

/***
 * Leetcode 622
 */
public class DesignCircularQueue {
    int[] queue;
    int head;
    int tail;
    int capacity;
    //loop invariant: [head,tail) is all the valid queue.
    public DesignCircularQueue(int k) {
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
