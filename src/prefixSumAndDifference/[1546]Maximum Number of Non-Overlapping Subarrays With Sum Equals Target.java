package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

class MaxNonOverlappingSolution {
    //贪心+前缀，尽量使得满足条件的子数组最短，所以记录preSum最大的index
    //同时记录目前为止最后一个满足条件的子数组结尾的index，保证不选择重复的subarray
    public int maxNonOverlapping(int[] nums, int target) {
        int n = nums.length;
        long sum = 0;
        int res = 0;
        //preSum -> index
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        int lastIndex = -2;
        for(int i = 0;i<n;i++){
            sum+=nums[i];
            long targetPreSum = sum-target;
            if(map.containsKey(targetPreSum)){
                //这里需要+1，因为targetPreSum所对应的index是数组开头的前一位
                if(map.get(targetPreSum)+1>lastIndex){
                    res++;
                    lastIndex = i;
                }
            }
            map.put(sum, i);
        }
        return res;
    }
}