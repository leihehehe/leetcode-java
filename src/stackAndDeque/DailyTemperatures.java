package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 * Leetcode 739
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for(int i =0;i<temperatures.length;i++){
            while(!stack.isEmpty() && temperatures[stack.peekLast()]<temperatures[i]){
                int preTop =stack.removeLast();
                res[preTop]=i-preTop;
            }
            stack.addLast(i);
        }
        return res;
    }
}
