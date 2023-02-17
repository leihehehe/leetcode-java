package dp;

/**
 * Leetcode 279
 */
public class PerfectSquares {
    /**
     * TIME: O(N*logN)
     * SPACE: O(N)
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0]=0;
        for(int i = 1;i<n+1;i++){
            dp[i] = n+1;
            for(int j = 1;j*j<=i;j++){
                if(i-j*j>=0)
                    dp[i] = Math.min(dp[i-j*j] +1,dp[i]);
            }
        }
        return dp[n];
    }
}
