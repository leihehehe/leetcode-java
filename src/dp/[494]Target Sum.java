package dp;

import java.util.HashMap;

/**
 * Leetcode 494
 */
class TargetSumBacktracking {
    HashMap<String, Integer> memo = new HashMap<>();

    /**
     * Method 1: backtracking
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        return backtrack(nums, 0, target);
    }

    public int backtrack(int[] nums, int index, int remain) {
        if (index == nums.length) {
            if (remain == 0) return 1;
            return 0;
        }
        String key = index + "," + remain;
        if (memo.containsKey(key)) return memo.get(key);
        // -
        remain += nums[index];
        int plus = backtrack(nums, index + 1, remain);
        remain -= nums[index];
        // +
        remain -= nums[index];
        int minus = backtrack(nums, index + 1, remain);
        remain -= nums[index];
        int res = plus + minus;
        memo.put(key, res);
        return res;
    }


}

class TargetSumDp {
    /**
     * Method 1: dp1
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        //we can chose number from [0..i] to
        //knapsack( -1,+1,+1,+1,-1 ) => sum =>
        //knapsack problem
        //n: number of all nums
        //plus: k
        //minus: n-k
        //plus-minus = target => k-(n-k) = 2k-n = target
        // k = (target+n)/2
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if ((target + sum) % 2 != 0 || target > sum) return 0;
        sum = (target + sum) / 2;
        if (sum < 0) return 0;
        //dp[i][j] => 从[0..i]中选出数字放入背包容量j，并刚好满足j的方法个数
        int[][] dp = new int[nums.length][sum + 1];
        dp[0][0] = 1;
        for (int i = 0; i <= sum; i++) {
            //将第一个数字 放入容量i，满足i的方法？
            if (nums[0] == i)
                dp[0][i] = 1;
        }
        if (nums[0] == 0) {
            dp[0][0] = 2;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][sum];
    }

    /**
     * Method 2: dp2
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