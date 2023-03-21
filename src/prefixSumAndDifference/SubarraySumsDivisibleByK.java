package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 974
 */
public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        //prefix sum
        int[] preSum = new int[nums.length+1];
        preSum[0]=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int res=0;
        for(int i=1;i<nums.length+1;i++){
            preSum[i] = preSum[i-1]+nums[i-1];
            //(preSum[i]-preSum[j])%k = 0;
            //preSum[i]%k - preSum[j]%k = 0;
            //preSum[i]%k = preSum[j]%k
            int curReminder = preSum[i]%k;
            //
            if(curReminder<0) curReminder+=k;
            if(!map.containsKey(curReminder)){
                map.put(curReminder,1);
            }else{
                //res should be calculated before upding the map
                res+=map.get(curReminder);
                map.put(curReminder,map.get(curReminder)+1);

            }
        }
        return res;
    }
}
