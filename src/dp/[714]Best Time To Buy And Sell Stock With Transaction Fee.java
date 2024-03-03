package dp;

import java.util.Arrays;

/**
 * Leetcode 714
 */
class BestTimeToBuyAndSellStockWithTransactionSolution1 {
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        dp = new int[n][2];
        for(int[] d : dp) Arrays.fill(d,-1);
        return dfs(prices, n-1, 0, fee);
    }

    public int dfs(int[] prices, int i, int hold, int fee){
        if(i<0){
            return hold==1?Integer.MIN_VALUE/2:0;
        }
        if(dp[i][hold]!=-1){
            return dp[i][hold];
        }
        if(hold==1){
            return dp[i][hold] = Math.max(dfs(prices,i-1,1,fee),dfs(prices,i-1,0,fee)-prices[i]);
        }
        return dp[i][hold] = Math.max(dfs(prices,i-1,0,fee),dfs(prices,i-1,1,fee)+prices[i]-fee);
    }
}
class BestTimeToBuyAndSellStockWithTransactionSolution2 {
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        dp = new int[n+1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE/2;
        for(int i = 0;i<n;i++){
            dp[i+1][1] = Math.max(dp[i][1],dp[i][0]-prices[i]);
            dp[i+1][0] = Math.max(dp[i][0],dp[i][1]+prices[i]-fee);
        }
        return dp[n][0];
    }
}
class BestTimeToBuyAndSellStockWithTransactionSolution3 {
    int[] dp;
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        dp = new int[2];
        dp[0] = 0;
        dp[1] = Integer.MIN_VALUE/2;
        for(int i = 0;i<n;i++){
            dp[1] = Math.max(dp[1],dp[0]-prices[i]);
            dp[0] = Math.max(dp[0],dp[1]+prices[i]-fee);
        }
        return dp[0];
    }
}