package dp;

/**
 * Leetcode 213
 */
public class HouseRobberII {
    /**
     * Method 1
     * TIME: O(N)
     * SPACE: O(N)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        return Math.max(robHelper(nums,0,n-2),robHelper(nums,1,n-1));
    }
    public int robHelper(int[] nums, int start, int end){
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[start][0] =0;
        dp[start][1] =nums[start];
        for(int i = start+1;i<=end;i++){
            dp[i][0]=Math.max(dp[i-1][1],dp[i-1][0]);
            dp[i][1]=dp[i-1][0]+nums[i];
        }
        return Math.max(dp[end][0],dp[end][1]);
    }

    /**
     * Method 2 - reduced space complexity
     * TIME: O(N)
     * SPACE: O(N)
     * @param nums
     * @return
     */
    public int robMethod2(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        return Math.max(robHelperMethod2(nums,0,n-2),robHelperMethod2(nums,1,n-1));
    }
    public int robHelperMethod2(int[] nums, int start, int end){
        int[]dp = new int[2];
        dp[0] =0;
        dp[1] =nums[start];
        for(int i = start+1;i<=end;i++){
            int prev = dp[0];
            dp[0]=Math.max(dp[1],dp[0]);
            dp[1]=prev+nums[i];
        }
        return Math.max(dp[0],dp[1]);
    }
}
