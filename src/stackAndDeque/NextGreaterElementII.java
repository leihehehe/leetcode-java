package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/***
 * Leetcode 503
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        int n = nums.length;
        for(int i=0;i<n*2-1;i++){
            while(!stack.isEmpty()&&nums[stack.peekLast()]<nums[i%n]){
                res[stack.removeLast()] = nums[i%n];
            }
            stack.addLast(i%n);
        }
        return res;

    }
}
