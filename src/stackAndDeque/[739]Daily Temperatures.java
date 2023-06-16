package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0;i<temperatures.length;i++){
            int cur = temperatures[i];
            if(stack.isEmpty()){
                stack.push(i);
            }else{
                while(!stack.isEmpty() && cur>temperatures[stack.peek()]){
                    int index = stack.pop();
                    answer[index] = i-index;
                }
                stack.push(i);
            }
        }
        return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
