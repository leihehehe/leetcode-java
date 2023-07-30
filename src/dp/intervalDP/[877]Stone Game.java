package dp.intervalDP;

//leetcode submit region begin(Prohibit modification and deletion)
class StoneGame {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        //dp[i][j] = Math.max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1]);
        //需要算出下方和左边
        for(int i = 0;i<n;i++){
            dp[i][i] = piles[i];
        }
        //make sure [i,j] is valid
        for(int j = 1;j<n;j++){
            for(int i = j-1;i>=0;i--){
                dp[i][j] = Math.max(piles[i]-dp[i+1][j],piles[j] - dp[i][j-1]);
            }
        }
        return dp[0][n-1]>0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
