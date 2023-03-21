package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 325
 */
public class MaximumSizeSubarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        int[] preSum = new int[nums.length+1];
        preSum[0] = 0;
        //preSum[i] - preSum[j] = k
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        map.put(0,0);
        for(int i =1;i<nums.length+1;i++){
            preSum[i] = preSum[i-1]+nums[i-1];
            if(!map.containsKey(preSum[i]))
                map.put(preSum[i],i);
            int need = preSum[i]-k;
            if(map.containsKey(need)){
                res = Math.max(res,i-map.get(need));
            }
        }
        return res;
    }
}
