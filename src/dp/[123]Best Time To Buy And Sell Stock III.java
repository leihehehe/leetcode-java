package dp;

/**
 * Leetcode 123
 */
class BestTimeToBuyAndSellStockIII {
    /**
     * use for loop
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
        for(int i = 0;i<n;i++){
            for(int k = 2;k>=1;k--){
                if(i==0){
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[0];
                }else{
                    dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                    dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
                }

            }

        }
        //这个地方似乎直接返回dp[n-1][2][0]即可，因为肯定transaction次数越高，利润越高
        return Math.max(dp[n-1][2][0],dp[n-1][1][0]);
    }
    /**
     * TIME: O(N)
     * SPACE: O(N^3)
     * @param prices
     * @return
     */
    public int maxProfitMethod2(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][3][2];//day,transaction,haveStock or not 0 and 1
        dp[0][0][0] = 0;
        dp[0][1][0] = 0;
        dp[0][1][1]=-prices[0];
        dp[0][2][1]=-prices[0];
        for(int i = 1;i<n;i++){
            //1 purchased, has stock -> yes 1 purchased has stock|| 0 purchased, -prices
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]) ;
            //1 purchased, no stock -> today not sell || today sell
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            //2 purchased, has stock -> today not buy || today buy
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            //2 purchased, no stock -> today not sell || today sell
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
        }
        return Math.max(dp[n-1][1][0],dp[n-1][2][0]);
    }
}
