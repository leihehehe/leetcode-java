package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class DailyTemperaturesSolution1 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                int top = stack.pop();
                ans[top] = i-top;
            }
            stack.push(i);
        }
        return ans;
    }
}
class DailyTemperaturesSolution2 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        //[73,74,75,71,69,72,76,73]
        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
