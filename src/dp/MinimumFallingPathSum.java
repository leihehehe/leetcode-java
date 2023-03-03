package dp;

/**
 * Leetcode 931
 */
public class MinimumFallingPathSum {
    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                if(i==0) dp[i][j] = matrix[i][j];
                if(i>0){
                    //above
                    dp[i][j] = dp[i-1][j]+matrix[i][j];
                    //upper left
                    if(j>0) dp[i][j] = Math.min(dp[i-1][j-1]+matrix[i][j],dp[i][j]);
                    //upper right
                    if(j<n-1) dp[i][j]= Math.min(dp[i-1][j+1]+matrix[i][j],dp[i][j]);
                }

            }
        }
        int res = Integer.MAX_VALUE;
        for(int num:dp[n-1]){
            res = Math.min(num,res);
        }
        return res;
    }
}
