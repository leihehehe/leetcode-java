package stackAndDeque.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] nums, int k) {
        long[] prefixSum = new long[nums.length+1];
        for(int i = 1;i<prefixSum.length;i++){
            prefixSum[i] = prefixSum[i-1]+nums[i-1];
        }
        Deque<Integer> monoQueue = new ArrayDeque<>();
        int minLen = nums.length+1;
        for(int i = 0;i<prefixSum.length;i++){
            while(!monoQueue.isEmpty() && prefixSum[i] - prefixSum[monoQueue.getFirst()]>=k){
                minLen = Math.min(minLen,i-monoQueue.pollFirst());
            }
            while(!monoQueue.isEmpty() && prefixSum[monoQueue.getLast()]>prefixSum[i]){
                monoQueue.pollLast();
            }
            monoQueue.addLast(i);
        }
        return minLen==nums.length+1?-1:minLen;
    }
}//leetcode submit region end(Prohibit modification and deletion)
