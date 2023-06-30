package dp;


class BestTimeToBuyAndSellStockWithCooldownV1{
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];

        for(int i = 0;i<n;i++){
            if(i==0){
                dp[0][0] = 0;
                dp[0][1] = -prices[i];
            }else if(i==1){
                //无股票，昨天也无股票，昨天有今天卖了
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                //有股票，今天买没买？今天没买，昨天买的，今天买了，昨天没有（前天才有，但因为是第1天，所以没有前天），
                dp[i][1] = Math.max(dp[i-1][1],-prices[i]);

            }else{
                //无股票
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                //今天有股票,我今天买没买？
                //没买(昨天就有了)
                //买了（前天刚卖，今天才能买）
                dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);

            }
        }
        return dp[n-1][0];
    }

    public int maxProfitOptimized(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[3][2];

        for(int i = 0;i<n;i++){
            if(i==0){
                dp[i%3][0] = 0;
                dp[i%3][1] = -prices[i];
            }else if(i==1){
                //无股票，昨天也无股票，昨天有今天卖了
                dp[i%3][0] = Math.max(dp[(i-1)%3][0],dp[(i-1)%3][1]+prices[i]);
                //有股票，今天买没买？今天没买，昨天买的，今天买了，昨天没有（前天才有，但因为是第1天，所以没有前天），
                dp[i%3][1] = Math.max(dp[(i-1)%3][1],-prices[i]);

            }else{
                //无股票
                dp[i%3][0] = Math.max(dp[(i-1)%3][0],dp[(i-1)%3][1]+prices[i]);
                //今天有股票,我今天买没买？
                //没买(昨天就有了)
                //买了（前天刚卖，今天才能买）
                dp[i%3][1] = Math.max(dp[(i-1)%3][1],dp[(i-2)%3][0]-prices[i]);

            }
        }
        return dp[(n-1)%3][0];
    }
}
/**
 * Leetcode 309
 */
class BestTimeToBuyAndSellStockWithCooldownV2 {
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
