package dp;

/**
 * Leetcode 714
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    /**
     * Method 1: dynamic programming
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp=new int[n][2];
        dp[0][1]=-prices[0]-fee;
        for(int i = 1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]-fee);
        }
        return dp[n-1][0];
    }

    /**
     * Method 2: Optimized method to reduce space complexity
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfitMethod2 (int[] prices, int fee) {
        int n = prices.length;
        // int[][] dp=new int[n][2];
        int[] dp = new int[2];
        dp[1]=-prices[0]-fee;
        for(int i = 1;i<n;i++){
            dp[0] = Math.max(dp[0],dp[1]+prices[i]);
            dp[1] = Math.max(dp[1],dp[0]-prices[i]-fee);
        }
        return dp[0];
    }
}
