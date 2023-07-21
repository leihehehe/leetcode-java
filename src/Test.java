import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.push(-2);
        test.push(0);
        test.push(-3);
        System.out.println(test.getMin());
    }
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> cache = new ArrayDeque<>();
    public void push(int val) {
        stack.push(val);
        while(!cache.isEmpty() && cache.peekLast()>val){
            cache.removeLast();
        }
        cache.addLast(val);
    }

    public void pop() {
        int val = stack.pop();
        if(val == cache.peekLast()){
            cache.pollLast();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return cache.getFirst();
    }
}
