package dp;

/**
 * Leetcode 714
 */
class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfitMethod1V1(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i = 0;i<n;i++){
            if(i==0){
                //the first day, we don't hold a stock
                dp[i][0] = 0;
                dp[i][1] = -prices[i]-fee;
            }else{
                //sold stock(yesteday we held a stock)
                dp[i][0] = Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
                dp[i][1] = Math.max(dp[i-1][0]-prices[i]-fee, dp[i-1][1]);
            }
        }
        return dp[n-1][0];
    }
    /**
     * Method 1: dynamic programming
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfitMethod1V2(int[] prices, int fee) {
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

    /**
     * Optimized
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfitMethod3(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[2][2];
        for(int i = 0;i<n;i++){
            if(i==0){
                //the first day, we don't hold a stock
                dp[i&1][0] = 0;
                dp[i&1][1] = -prices[i]-fee;
            }else{
                //sold stock(yesteday we held a stock)
                dp[i&1][0] = Math.max(dp[(i-1)&1][1]+prices[i],dp[(i-1)&1][0]);
                dp[i&1][1] = Math.max(dp[(i-1)&1][0]-prices[i]-fee, dp[(i-1)&1][1]);
            }
        }
        return dp[(n-1)&1][0];
    }
}
