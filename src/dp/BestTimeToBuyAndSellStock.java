package dp;

/**
 * Leetcode 121
 */
public class BestTimeToBuyAndSellStock {
    /**
     * Method 1: Brute force
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                maxProfit = Math.max(prices[j]-prices[i],maxProfit);
            }
        }
        return Math.max(maxProfit, 0);
    }
    /**
     * Method 2: find min value(actually simplified version of method 4)
     */

    public int maxProfitMethod2(int[] prices) {
        int n = prices.length;
        //find the minimum
        int min = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            min = Math.min(min,prices[i]);
            profit=Math.max(profit,prices[i]-min);
        }
        return profit;
    }

    /**
     * Method 3: a general template for buy & sell stock related problems
     * @param prices
     * @return
     */
    public int maxProfitMethod3(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];//2 refers to hold the stock or not
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i =1;i<n;i++){
            //today no stock -> max(yesterday no stock, yesterday has stock today sold)
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //today has stock -> max(yesterday has no stock today buy, yesterday has stock)
            dp[i][1] = Math.max(-prices[i],dp[i-1][1]);
        }
        return dp[n-1][0];
    }

    /**
     * Method 4: normal dynamic programming alg
     * @param prices
     * @return
     */
    public int maxProfitMethod4(int[] prices) {
        int n = prices.length;
        int[] dp= new int[n];
        int min=prices[0];
        dp[0]=0;
        for(int i =1;i<n;i++){
            dp[i] = Math.max(dp[i-1],prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return dp[n-1];
    }
}
