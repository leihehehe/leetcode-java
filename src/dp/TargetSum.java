package dp;

import java.util.HashMap;

/**
 * Leetcode 494
 */
public class TargetSum {
    /**
     * Method 1: backtracking
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums,0,target);
    }

    HashMap<String, Integer> memo = new HashMap<>();
    public int backtrack(int[] nums, int index, int remain){
        if(index == nums.length){
            if(remain==0) return 1;
            return 0;
        }
        String key = index +","+remain;
        if(memo.containsKey(key)) return memo.get(key);
        // -
        remain+=nums[index];
        int plus =backtrack(nums,index+1,remain);
        remain-=nums[index];
        // +
        remain-=nums[index];
        int minus = backtrack(nums,index+1,remain);
        remain-=nums[index];
        int res = plus+minus;
        memo.put(key,res);
        return res;
    }

    /**
     * Method 2: dp
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWaysMethod2(int[] nums, int target) {
        //1+1+1-(2+2+2)=target
        //sum(A)-sum(B)=target
        //sum(A)+sum(A) = target+sum(A)+sum(B)
        //2*sum(A) = target+sum(nums)
        //sum(A) = (sum(nums)-target)/2
        int sum = 0;
        for(int num: nums) sum+=num;
        sum = (sum-target)/2;
        //dp[i][j]=> the number of different expressions that nums[0..i-1] has sum of `j`
        int[][] dp = new int[nums.length+1][sum+1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= nums[i-1]) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][sum];
    }
}
