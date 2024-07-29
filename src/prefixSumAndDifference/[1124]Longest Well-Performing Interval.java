package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 1124
 */
class LongestWPISolution {
    public int longestWPI(int[] hours) {
        int sum = 0;
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int j = 0;j<hours.length;j++){
            sum+=hours[j]>8?1:-1;
            if(sum>0){
                res = Math.max(j+1,res);
            }else{
                //preSum[j] - preSum[i] > 0
                //preSum[i] < preSum[j]
                //因为是负数，所以更小的preSum[i]一定会出现在preSum[j]-1的右边，因此我们只需要记录第一次preSum[j]-1出现的位置即可
                int target = sum-1;
                if(map.containsKey(target)){
                    res = Math.max(res,j-map.get(target));
                }
            }
            if(!map.containsKey(sum)){
                map.put(sum,j);
            }
        }
        return res;
    }
}
