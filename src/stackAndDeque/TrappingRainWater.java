package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 * Leetcode 42
 */
public class TrappingRainWater {
    /***
     * Method 1: stack
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int len = height.length;
        //if there is no complete trap
        if(len<3){
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int sum=0;
        for(int i=0;i<len;i++){
            //this loop is to iterate all the left-hand-side walls.
            while(!stack.isEmpty() && height[stack.peekLast()]<height[i]){
                int baseIndex = stack.removeLast();
                //if there's no more left-hand-side wall
                if(stack.isEmpty()){
                    break;
                }
                int leftIndex = stack.peekLast();
                int currentHeight= Math.min(height[leftIndex],height[i])-height[baseIndex];
                int width = i-leftIndex-1;
                sum+=currentHeight * width;
            }
            stack.addLast(i);
        }
        return sum;
    }
}
