package prefixSumAndDifference;

import java.util.HashMap;

class NumSubarraysWithSumSolution1 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = 3*(int)1e4+1;
        int[] map = new int[n];
        // HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map[0] = 1;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            int target = sum-goal;
            if(target>=0)
                res += map[target];
            map[sum]=map[sum]+1;
        }
        return res;
    }
}
class NumSubarraysWithSumSolution2 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map.put(0,1);
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            int target = sum-goal;
            res += map.getOrDefault(target, 0);
            map.put(sum,map.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}