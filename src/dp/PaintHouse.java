package dp;

/**
 * Leetcode 256
 */
public class PaintHouse {
    /**
     * Method 1: 3-dimensional array
     * TIME: O(N)
     * SPACE: O(N^2)
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        int n =costs.length;
        int[][] dp = new int[n][3];
        dp[0][0]=costs[0][0];
        dp[0][1]=costs[0][1];
        dp[0][2]=costs[0][2];
        for(int i =1;i<n;i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+costs[i][2];
        }
        int res = Math.min(Math.min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]);
        return res;
    }

    /**
     * Method 2: an optimized method for reducing space complexity.
     * TIME: O(N)
     * SPACE: O(N)
     * @param costs
     * @return
     */
    public int minCostMethod2(int[][] costs) {
        int n =costs.length;
        int[] dp = new int[3];
        dp[0]=costs[0][0];
        dp[1]=costs[0][1];
        dp[2]=costs[0][2];
        for(int i =1;i<n;i++){
            int pre0 = dp[0];
            int pre1 = dp[1];
            dp[0] = Math.min(pre0,dp[2])+costs[i][0];
            dp[1] = Math.min(pre0,dp[2])+costs[i][1];
            dp[2] = Math.min(pre0,pre1)+costs[i][2];
        }
        return Math.min(Math.min(dp[0],dp[1]),dp[2]);
    }
}
