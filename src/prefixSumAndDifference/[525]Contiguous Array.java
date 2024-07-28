package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 525
 */
class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int res = 0;
        //sum -> index
        Map<Integer,Integer> map= new HashMap<>();
        map.put(0, -1);
        for(int i = 0;i<n;i++){
            //将0变为-1，求和为0的子数组
            sum = nums[i]==0?sum+(-1):sum+nums[i];
            if(map.containsKey(sum)){
                res = Math.max(res, i-map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        return res;
    }

}
