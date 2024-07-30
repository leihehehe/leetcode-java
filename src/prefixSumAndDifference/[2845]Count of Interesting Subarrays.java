package prefixSumAndDifference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CountInterestingSubarraysSolution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long sum = 0;
        Map<Long,Integer> map = new HashMap<>();
        map.put(0L,1);
        long res = 0;
        for(int i = 0;i<nums.size();i++){
            int num = nums.get(i);
            sum=num%modulo==k?(sum+1)%modulo:(sum)%modulo;
            long target = (sum - k + modulo)%modulo;
            res+=map.getOrDefault(target,0);
            map.merge(sum, 1, Integer::sum);
        }
        return res;
    }
}
