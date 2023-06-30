package dp;

/**
 * Leetcode 122
 */
class BestTimeToBuyAndSellStockII {
    /**
     * TIME: O(N)
     * SPACE: O(N^2)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i =1;i<n;i++){

            dp[i][0] = Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }
        return dp[n-1][0];
    }

    /**
     * Space complexity reduced
     * @param prices
     * @return
     */
    public int maxProfitSimplified(int[] prices) {
        int n = prices.length;
        //dp[i][j] => 在end of 第i天的状态是j(0:不持有股票，1:持有股票)
        //不持有，今天卖了又卖掉了，相当于没买/没买
        int notHold = 0;
        //持有，今天买了
        int hold = -prices[0];
        for(int i = 1;i<n;i++){
            int temp = notHold;
            //今天不持有股票 =>今天持有，今天卖掉/昨天不持有/昨天持有，今天卖掉
            notHold = Math.max(notHold,hold+prices[i]);
            //今天持有股票 =>昨天不持有,今天买/昨天持有
            hold = Math.max(temp-prices[i],hold);
        }
        return notHold;
    }
}
