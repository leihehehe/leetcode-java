package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 * Leetcode 239
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        for(int i =0;i<nums.length;i++){
            //remove all the elements in the deque that are smaller than the current element
            while(!deque.isEmpty()&&nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            //remove the head of queue since the slinding windows is moving
            if(!deque.isEmpty()&&deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            //add new element to the deque
            deque.addLast(i);
            //save the max value
            if(i>=k-1){
                res[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
