package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

class MaximumSubarraySumSolution {
    public long maximumSubarraySum(int[] nums, int k) {
        // |nums[i]-nums[j]| = k
        //nums[i] - nums[j] = -k or k
        //nums[i] = nums[j]-k or nums[j]+k
        //get max sum -> preSum[j] - preSum[i], preSum[i]要尽量小
        int n = nums.length;
        //num -> 该坐标之前的preSum（不包含该坐标）
        Map<Integer,Long> map = new HashMap<>();
        long curSum = 0;
        long res = Long.MIN_VALUE;
        for(int j = 0;j<n;j++){
            curSum+=nums[j];
            int target1 = nums[j]-k;
            int target2 = nums[j]+k;
            if(map.containsKey(target1))
                res = Math.max(res, curSum - map.get(target1));
            if(map.containsKey(target2))
                res = Math.max(res, curSum - map.get(target2));
            if(!map.containsKey(nums[j]))
                map.put(nums[j], curSum-nums[j]);
            else
                map.put(nums[j], Math.min(curSum-nums[j], map.get(nums[j])));
        }
        return res==Long.MIN_VALUE?0:res;

    }
}