package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 325
 */
class MaxSubArrayLenSolution {
    public int maxSubArrayLen(int[] nums, int k) {
        long sum = 0;
        Map<Long,Integer> map = new HashMap<>();
        map.put(0L,-1);
        int res = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            long target = sum - k;
            if(map.containsKey(target)){
                res = Math.max(res, i-map.get(target));
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return res;
    }
}
