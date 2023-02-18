package dp;

/**
 * Leetcode 62
 */
public class UniquePaths {
    /**
     * TIME: O(m*n)
     * SPACE: O(m*n)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        //dp[3][7] = dp[3][6]*1
        //dp[3][7] = dp[2][7]*1
        //so dp[3][7] = dp[3][6]*1+dp[2][7]*1
        int[][] dp = new int[m+1][n+1];
        for(int i = 1; i <m+1;i++){
            for(int j = 1; j <n+1; j++){
                if(i == 1 || j == 1) dp[i][j]=1;
                else dp[i][j] += dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}
