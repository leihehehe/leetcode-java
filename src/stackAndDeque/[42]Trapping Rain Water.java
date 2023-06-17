package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class TrappingRainWater {
    public int trap(int[] height) {
        //stack storing indices
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        for(int i =0;i<height.length;i++){
            while(!stack.isEmpty() && height[stack.peek()] <height[i]){
                //stack.size() == 1?
                int midIndex = stack.pop();
                int midHeight = height[midIndex];
                if(!stack.isEmpty()){
                    int leftIndex = stack.peek();
                    int waterHeight = Math.min(height[leftIndex],height[i])-midHeight;
                    int waterWidth = i-leftIndex-1;
                    sum+=waterHeight*waterWidth;
                }

            }
            stack.push(i);
        }
        return sum;
    }

}

//leetcode submit region end(Prohibit modification and deletion)
