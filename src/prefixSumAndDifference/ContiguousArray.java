package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 525
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n+1];
        preSum[0]=0;
        Map<Integer,Integer> valToIndex = new HashMap<>();
        int res = 0;
        valToIndex.put(preSum[0],0);
        for(int i =1;i<=n;i++) {
            preSum[i] = preSum[i-1]+(nums[i-1]==0?-1:1);
            if(!valToIndex.containsKey(preSum[i]))
                valToIndex.put(preSum[i],i);
            else res = Math.max(res, i - valToIndex.get(preSum[i]));
        }
        return res;
    }
}
