package stackAndDeque;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    Queue<Integer> queue;
    public ImplementStackUsingQueues() {
        queue=new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {

        for(int i =0;i<queue.size()-1;i++){
            queue.add(queue.poll());
        }
        return queue.poll();
    }

    public int top() {
        for(int i =0;i<queue.size()-1;i++){
            queue.add(queue.poll());
        }
        int res = queue.poll();
        queue.add(res);
        return res;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
