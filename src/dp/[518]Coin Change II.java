package dp;

/**
 * Leetcode 518
 *
 */
class CoinChangeIISolution1 {
    /**
     * Complete knapsack
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                //选这个硬币
                if (j >= coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    //不选这个硬币
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }

    /**
     * Optimized dp
     * @param amount
     * @param coins
     * @return
     */
    public int changeII(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int i = 1;i<=n;i++){
            for(int j =0;j<=amount;j++){
                //选这个硬币
                if(j>=coins[i-1]){
                    dp[j] = dp[j]+dp[j-coins[i-1]];
                }
            }
        }
        return dp[amount];
    }
}
class CoinChangeIISolution2 {
    /**
     * Method 1: dp
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        //dp[i][j] => how many combination when choosing from coins[0..i] to get amount j
        int m = coins.length;
        int[][] dp = new int[m+1][amount+1];
        //dp[0][j] => when no coins => 0
        //dp[i][0] => when no amount => 1
        for(int i = 0;i<=m;i++) dp[i][0]=1;
        for(int i =1;i<=m;i++){
            for(int j = 1;j<amount+1;j++){
                //check if sum >= coins[i] -> check if this denomination fits
                if(j-coins[i-1]>=0){
                    //do not use this denomination
                    dp[i][j] = dp[i-1][j];
                    //use coins[0..i] -> do use this denomination
                    dp[i][j] += dp[i][j-coins[i-1]];
                }else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[m][amount];
    }

    /**
     * Method 2: optimized dp
     * @param amount
     * @param coins
     * @return
     */
    public int changeMethod2(int amount, int[] coins) {
        //dp[i][j] => how many combination when choosing from coins[0..i] to get amount j
        int m = coins.length;
        // int[][] dp = new int[m+1][amount+1];
        int[] dp = new int[amount+1];
        //dp[0][j] => when no coins => 0
        //dp[i][0] => when no amount => 1
        dp[0]=1;
        for(int i =1;i<=m;i++){
            for(int j = 0;j<=amount;j++){
                //check if sum >= coins[i] -> check if this denomination fits
                if(j-coins[i-1]>=0){
                    dp[j] += dp[j-coins[i-1]];
                }
            }
        }
        return dp[amount];
    }
}
