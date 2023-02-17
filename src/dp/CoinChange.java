package dp;

/**
 * Leetcode 322
 */
public class CoinChange {
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
