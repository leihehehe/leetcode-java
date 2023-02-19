package dp;

/**
 * Leetcode 63
 */
public class UniquePathsII {
    /**
     * Method 1: double dimensional array
     * TIME: O(m*n)
     * SPACE: O(m*n)
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp =new int[m][n];
        dp[0][0]=obstacleGrid[0][0]==1?0:1;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(obstacleGrid[i][j]==1) continue;
                if(i>=1 && obstacleGrid[i-1][j]!=1) dp[i][j]+=dp[i-1][j];
                if(j>=1 && obstacleGrid[i][j-1]!=1) dp[i][j]+=dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * Optimized Method: using two-dimensional array
     * TIME: O(m*n)
     * SPACE: O(n)
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstaclesOptimized(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];//current row
        dp[0] = obstacleGrid[0][0]==1?0:1;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n; j++){
                if(obstacleGrid[i][j]==1){
                    dp[j] = 0;
                    continue;
                }
                if(j>=1&&obstacleGrid[i][j-1]!=1) dp[j]+=dp[j-1];//left
            }
        }
        return dp[n-1];
    }
}
