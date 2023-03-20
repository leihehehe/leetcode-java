package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 560
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length+1];
        preSum[0]=0;
        Map<Integer,Integer> map = new HashMap<>();
        //preSum[i] - preSum[j] = k
        //preSum[j] = presum[i]-k;
        int count = 0;
        map.put(0,1);
        for(int i = 1;i<nums.length+1;i++){
            preSum[i] = preSum[i-1]+nums[i-1];
            int need = preSum[i]-k;
            if(map.containsKey(need)){
                count += map.get(need);
            }
            if(!map.containsKey(preSum[i])){
                map.put(preSum[i],1);
            }else map.put(preSum[i],map.get(preSum[i])+1);


        }
        return count;
    }
}
