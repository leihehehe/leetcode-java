package dp;

/**
 * Leetcode 64
 */
public class MinimumPathSum {
    /**
     * Method 1: two-dimensional array
     * TIME: O(n^2)
     * SPACE: O(n^2)
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0]=grid[0][0];
        for(int i =0;i<m;i++){
            for(int j = 0; j< n ;j++){
                if(i>=1 && j>=1)
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                else if(i>=1) dp[i][j]=dp[i-1][j]+grid[i][j];
                else if(j>=1) dp[i][j]=dp[i][j-1]+grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * Optimized Method: using one-dimensional array
     * TIME: O(n^2)
     * SPACE: O(n)
     * @param grid
     * @return
     */
    public int minPathSumMethod2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0]=grid[0][0];
        for(int i =0;i<m;i++){
            for(int j = 0; j< n ;j++){
                if(i>=1 && j>=1)
                    dp[j]=Math.min(dp[j],dp[j-1])+grid[i][j];
                else if(i>=1) dp[j]=dp[j]+grid[i][j];
                else if(j>=1) dp[j]=dp[j-1]+grid[i][j];
            }
        }
        return dp[n-1];
    }
}
