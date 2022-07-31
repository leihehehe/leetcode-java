package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 * Leetcode 84
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] newHeights = new int[heights.length+2];
        int maxArea = 0;
        //add 0 to the start and end of heights[]
        for(int i =1;i<heights.length+1;i++){
            newHeights[i]=heights[i-1];
        }
        for(int i =0;i<newHeights.length;i++){
            while(!stack.isEmpty()&&newHeights[stack.peekLast()]>newHeights[i]){
                maxArea=Math.max(maxArea,newHeights[stack.removeLast()]*(i-stack.peekLast()-1));
            }
            stack.addLast(i);
        }
        return maxArea;
    }
}
