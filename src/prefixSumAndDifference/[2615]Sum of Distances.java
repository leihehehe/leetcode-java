package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

class DistanceSolution {
    public long[] distance(int[] nums) {
        //preSum
        //|i-a| + |i-b| + |i-c| = i*count - (a+b+c)
        //suffixSum
        int n = nums.length;
        //num -> sum
        //这里可以优化成map中为数组的类型
        Map<Integer,Long> suffixSumMap = new HashMap<>();
        Map<Integer,Long> preSumMap = new HashMap<>();
        Map<Integer,Long> preCountMap = new HashMap<>();
        Map<Integer,Long> suffixCountMap = new HashMap<>();
        for(int i = 0;i<n;i++){
            suffixSumMap.merge(nums[i], (long)i, Long::sum);
            suffixCountMap.merge(nums[i], 1L, Long::sum);
        }
        long[] res = new long[n];
        for(int i = 0;i<n;i++){
            suffixSumMap.merge(nums[i], (long)-i, Long::sum);
            suffixCountMap.merge(nums[i], -1L,Long::sum);
            long prefix = i * preCountMap.getOrDefault(nums[i], 0L) - preSumMap.getOrDefault(nums[i], 0L);
            long suffix = suffixSumMap.getOrDefault(nums[i], 0L) - i * suffixCountMap.getOrDefault(nums[i], 0L);
            res[i] = prefix + suffix;
            preSumMap.merge(nums[i], (long)i, Long::sum);
            preCountMap.merge(nums[i], 1L, Long::sum);
        }
        return res;
    }
}
