package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 * Leetcode 155
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
public class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    public void push(int x) {
        if(minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
        stack.push(x);
    }
    public void pop() {
        if(stack.pop().equals(minStack.peek()))
            minStack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }
}
