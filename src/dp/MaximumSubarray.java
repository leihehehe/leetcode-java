package dp;

/**
 * Leetcode 53
 */
public class MaximumSubarray {
    /**
     * Method 1: dynamic programming
     * Time complexity: O(N)
     * Space complexity: O(N)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1;i<n;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for(int num:dp){
            res = Math.max(res,num);
        }
        return res;
    }

    /**
     * Method 2: reduced space complexity using variables
     * Time complexity: O(N)
     * Space complexity: O(1)
     * @param nums
     * @return
     */
    public int maxSubArrayMethod2(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        int maxSum = sum;
        for(int i = 1;i<n;i++){
            sum = Math.max(sum+nums[i],nums[i]);
            maxSum = Math.max(sum,maxSum);
        }

        return maxSum;
    }
}
