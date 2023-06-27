package dp;

import java.util.Arrays;

class CoinChangeSolution1{
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        //从coins[1.n]中选，放入容量为amount的背包刚好装满，最少需要多少硬币？
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i = 1;i<=n;i++){
            for(int j =1;j<=amount;j++){
                //不选
                dp[j] = dp[j];
                //选
                if(j>=coins[i-1] && dp[j-coins[i-1]]!=Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j],dp[j-coins[i-1]]+1);
                }

            }
        }
        return dp[amount]!=Integer.MAX_VALUE?dp[amount]:-1;
    }
}
/**
 * Leetcode 322
 */
class CoinChangeSolution2 {
    /**
     * TIME: O(N*amount)
     * SPACE: O(amount)
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        //f(i) = f(i-1)+1
        int[] dp = new int[amount+1];
        for(int i = 1;i<amount+1;i++){
            dp[i]=amount+1;
            for(int coin:coins){
                if(i-coin>=0)
                    dp[i] = Math.min(dp[i-coin]+1,dp[i]);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
