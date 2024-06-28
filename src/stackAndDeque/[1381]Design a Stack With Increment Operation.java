package stackAndDeque;

import java.util.ArrayDeque;

class CustomStackSolution1 {
    ArrayDeque<Integer> queue;
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    int maxSize;
    public CustomStackSolution1(int maxSize) {
        queue = new ArrayDeque<>();
        stack = new ArrayDeque<>();
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if(queue.size()==maxSize) return;
        queue.addLast(x);
    }

    public int pop() {
        if(queue.isEmpty()) return -1;
        return queue.removeLast();
    }

    public void increment(int k, int val) {
        while(k-- > 0){
            if(queue.isEmpty()) break;
            stack.push(queue.removeFirst()+val);
        }
        while(!stack.isEmpty()){
            queue.addFirst(stack.pop());
        }
    }
}
class CustomStackSolution2 {
    int[] stack;
    //[head,tail)
    int head = 0, tail = 0;
    int maxSize;
    public CustomStackSolution2(int maxSize) {
        stack = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if(tail-head==maxSize){
            return;
        }
        stack[tail++] = x;
    }

    public int pop() {
        if(tail-head==0) return -1;
        return stack[--tail];
    }

    public void increment(int k, int val) {
        int i = head;
        while(k-->0 && i<tail){
            stack[i++] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */