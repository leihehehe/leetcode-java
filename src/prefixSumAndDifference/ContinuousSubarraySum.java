package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 523
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        //find a interval res[] -> sum%k=0
        int[] preSum = new int[nums.length+1];
        preSum[0]=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(preSum[0]%k,0);
        for(int i =1;i<nums.length+1;i++){
            preSum[i]=preSum[i-1]+nums[i-1];
            int key = preSum[i]%k;
            if(!map.containsKey(key)){
                map.put(key,i);
            }
        }
        //(preSum[i] - preSum[j]) % k == 0 && i - j >= 2。
        //preSum[i] % k = preSum[j] % k
        for(int i = 1;i<preSum.length;i++){
            int need = preSum[i]%k;
            if(map.containsKey(need)){
                if(i-map.get(need)>=2) return true;
            }
        }
        return false;
    }
}
