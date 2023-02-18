package dp;

/**
 * Leetcode 198
 */
public class HouseRobber {
    /**
     * TIME: O(N)
     * SPACE: O(N)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int[] dp = new int[n];
        //dp[i] -> max amount
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);
        for(int i =2;i<n;i++){
            dp[i]= Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}