package dp;

import java.util.Arrays;

/**
 * Leetcode 377
 */
class CombinationSum4Solution1 {
    public int combinationSum4(int[] nums, int target) {
        memo = new int[target+1];
        Arrays.fill(memo,-1);
        return dfs(nums,target);
    }
    int[] memo;
    public int dfs(int[] nums, int target){
        if(target==0) return 1;
        if(target<0) return 0;
        if(memo[target]!=-1) return memo[target];
        int res = 0;
        for(int num:nums){
            if(target<num) continue;
            res+=dfs(nums,target-num);
        }
        return memo[target] = res;
    }
}
class CombinationSum4Solution2 {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target+1];
        memo[0] = 1;
        for(int i = 1;i<=target;i++){
            int res = 0;
            for(int num:nums){
                if(i<num) continue;
                res+=memo[i-num];
            }
            memo[i] = res;
        }
        return memo[target];
    }
}