package prefixSumAndDifference;

import java.util.HashMap;
import java.util.Map;

class BeautifulSubarraysSolution1 {
    public long beautifulSubarrays(int[] nums) {
        int max = 1<<21;
        int preXor = 0;
        int[] map = new int[max+1];
        map[0] = 1;
        long res = 0;
        for(int i = 0;i<nums.length;i++){
            preXor = preXor^nums[i];
            res+=map[preXor];
            map[preXor]++;
        }
        return res;
    }
}
class BeautifulSubarraysSolution2 {
    public long beautifulSubarrays(int[] nums) {
        int n = nums.length;
        int preXor = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        long res = 0;
        for(int i = 0;i<n;i++){
            preXor = preXor^nums[i];
            res+=map.getOrDefault(preXor, 0);
            map.put(preXor,map.getOrDefault(preXor, 0)+1);
        }
        return res;
    }
}
