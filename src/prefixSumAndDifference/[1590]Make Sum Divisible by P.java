package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

class MinSubarraySolution {
    public int minSubarray(int[] nums, int p) {

        //(totalSum - x) % p = 0
        //totalSum%p = x%p
        //总前缀和%p = 被删除的子数组%p
        int n = nums.length;
        long totalSum = 0;
        for(int num:nums){
            totalSum+=num;
        }
        totalSum = totalSum%p;
        if(totalSum==0) return 0;
        long sum = 0;
        int len = n;
        //sum -> index
        Map<Long,Integer> map = new HashMap<>();
        map.put(0L,-1);
        for(int i = 0;i<n;i++){
            sum = sum + nums[i];
            long target = (sum - totalSum+p)%p;
            if(map.containsKey(target)){
                len = Math.min(len,i-map.get(target));
            }
            map.put(sum%p, i);
        }
        return len==n?-1:len;
    }
}
