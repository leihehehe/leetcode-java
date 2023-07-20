package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/***
 * Leecode 232
 */
class implementQueueUsingStacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public implementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        updateStack();
        return stack2.pop();
    }

    public int peek() {
        updateStack();
        return stack2.peek();
    }

    public void updateStack(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
