package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 974
 */
class SubarraysDivByKSolution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int res = 0;
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum= (sum + nums[i])%k;
            if(sum<0){
                sum+=k;
            }
            res+=map.getOrDefault(sum, 0);
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}