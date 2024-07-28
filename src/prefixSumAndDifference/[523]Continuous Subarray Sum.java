package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 523
 */
class ContinuousSubarraySumSolution1 {
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
class ContinuousSubarraySumSolution2 {
    public boolean checkSubarraySum(int[] nums, int k) {
        //(x-y)%k = 0
        //x%k == y%k
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 1;i<nums.length;i++){
            map.put(sum, map.getOrDefault(sum, 0)+1);
            sum = (sum+nums[i-1])%k;
            if(sum<0) sum+=k;
            int curSum = (sum+nums[i])%k;
            if(curSum<0) curSum+=k;
            if(map.getOrDefault(curSum,0)>0){
                return true;
            }

        }
        return false;
    }
}