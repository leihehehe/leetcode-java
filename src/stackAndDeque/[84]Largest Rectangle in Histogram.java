package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for(int i = 0;i<=heights.length;i++){
            int cur;
            if(i==heights.length){
                cur = 0;
            }else{
                cur = heights[i];
            }
            while(!stack.isEmpty() && cur<=heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea,height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
