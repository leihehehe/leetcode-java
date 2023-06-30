package dp;

class BestTimeToBuyAndSellStockIVSolution1{
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][k+1][2];
        for(int i = 0;i<n;i++){
            for(int j=k;j>=1;j--){
                if(i==0){
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[0];
                }else{
                    dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                    dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
                }

            }
        }
        return dp[n-1][k][0];
    }
}
class BestTimeToBuyAndSellStockIVSolution2 {
    /**
     * Method 1: dynamic programming
     * TIME: O(NK)
     * SPACE: O(NK)
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        //days/transactions/stock?
        int[][][] dp = new int[n][k+1][2];
        for (int i = 0,  j = 0; j < k+1; j++) {
            dp[i][j][1] = -prices[i];
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k+1; j++) {
                dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
                res=Math.max(res,dp[i][j][0]);
            }
        }

        return res;
    }

    /**
     * Optimized dynamic programming
     * TIME: O(N*K)
     * SPACE: O(K)
     * @param k
     * @param prices
     * @return
     */
    public int maxProfitMethod2(int k, int[] prices) {
        int n = prices.length;
        //days/transactions/stock?
        int[][] dp = new int[k+1][2];
        for (int j = 0; j < k+1; j++) {
            dp[j][1] = -prices[0];
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k+1; j++) {
                dp[j][0]=Math.max(dp[j][0],dp[j][1]+prices[i]);
                dp[j][1] = Math.max(dp[j][1],dp[j-1][0]-prices[i]);
                res=Math.max(res,dp[j][0]);
            }
        }

        return res;
    }
}
