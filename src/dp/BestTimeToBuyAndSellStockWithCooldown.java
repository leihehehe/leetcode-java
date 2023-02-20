package dp;

/**
 * Leetcode 309
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    /**
     * Method 1
     * TIME: O(N)
     * SPACE: O(N^2)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<=1) return 0;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0],dp[0][1]+prices[1]);
        dp[1][1] = Math.max(-prices[0],-prices[1]);
        for(int i = 2;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }
        return dp[n-1][0];
    }

    /**
     * Optimized method that removes dp array and uses variables to reduce the space complexity.
     * TIME: O(N)
     * SPACE: O(1)
     */
    public int maxProfitMethod2(int[] prices) {
        int n = prices.length;
        if(n<=1) return 0;
        int dp_i_2_0=0,
                dp_i_2_1=-prices[0],
                dp_i_1_0= Math.max(0,dp_i_2_1+prices[1]),
                dp_i_1_1=Math.max(-prices[0],-prices[1]);
        if(n==2) return dp_i_1_0;
        int dp_i_0=0;
        int dp_i_1=0;
        for(int i = 2;i<n;i++){
            dp_i_0 = Math.max(dp_i_1_0,dp_i_1_1+prices[i]);
            dp_i_1 = Math.max(dp_i_1_1,dp_i_2_0-prices[i]);
            dp_i_2_0 = dp_i_1_0;
            dp_i_2_1 = dp_i_1_1;
            dp_i_1_0 = dp_i_0;
            dp_i_1_1 = dp_i_1;
        }
        return dp_i_0;
    }
}
