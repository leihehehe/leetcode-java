package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 * Leecode 232
 */
public class implementQueueUsingStacks {
    private Deque<Integer> pushStack;
    private Deque<Integer> popStack;
    public implementQueueUsingStacks() {
        pushStack = new ArrayDeque<>();
        popStack = new ArrayDeque<>();
    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        if(popStack.isEmpty()){
            pushToPop();
        }
        return popStack.pop();
    }

    public int peek() {
        if(popStack.isEmpty()){
            pushToPop();
        }
        return popStack.peek();
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
    public void pushToPop(){
        while(!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }
    }
}
