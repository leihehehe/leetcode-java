package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

class WaysToPartitionSolution {
    public int waysToPartition(int[] nums, int k) {
        int res = 0;
        //sum -> count
        Map<Long, Integer> prefixMap = new HashMap<>();
        Map<Long, Integer> suffixMap = new HashMap<>();
        long totalSum = 0;
        for(int i = nums.length-1;i>=0;i--){
            totalSum+=nums[i];
            suffixMap.merge(totalSum, 1, Integer::sum);
        }
        //整个数组的总和应该在 totalSum 中记录，而不需要放入 suffixMap 中进行计数。这样可以避免在计算分割点时出现重复计算的问题
        //比如[0,0,0] -> sum为0的有3个，但实际分割方式只有2种，所以最后一个元素不放入map中
        suffixMap.merge(totalSum, -1, Integer::sum);
        if(totalSum%2==0){
            res = suffixMap.getOrDefault(totalSum/2, 0);
        }
        //遍历每个num来修改
        long curSum = 0;
        long suffixSum = totalSum;
        for(int i = 0;i<nums.length;i++){
            //如果分割点在i之前，那么我们应该找prefix ->target = (sum + diff)/2
            //如果分割点在i之后，那么我们应该找suffix ->target = (sum + diff)/2
            curSum += nums[i];
            long diff = k-nums[i];
            if((totalSum + diff)%2==0){
                long target = (totalSum + diff)/2;
                res = Math.max(prefixMap.getOrDefault(target,0)+suffixMap.getOrDefault(target, 0),res) ;
            }
            prefixMap.merge(curSum, 1, Integer::sum);
            suffixSum-=nums[i];
            suffixMap.merge(suffixSum,-1,Integer::sum);
            if(suffixMap.get(suffixSum)<=0) suffixMap.remove(suffixSum);
        }
        return res;
    }
}