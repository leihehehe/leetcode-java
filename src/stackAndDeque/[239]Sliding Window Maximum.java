package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 * Leetcode 239
 */
class SlidingWindowMaximum {
    public int[] maxSlidingWindowMethod1(int[] nums, int k) {
        //max
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        int l = 0, r = 0;
        //[l,r)
        while(r<nums.length){
            int toAdd = nums[r];
            while(!deque.isEmpty() && nums[deque.peekLast()]< toAdd){
                deque.pollLast();
            }
            deque.addLast(r);
            r++;
            if(r-l>=k){
                res[l]=nums[deque.peekFirst()];
                if(l==deque.peekFirst()){
                    deque.pollFirst();
                }
                l++;

            }
        }
        return res;

    }
    public int[] maxSlidingWindowMethod2(int[] nums, int k) {
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
