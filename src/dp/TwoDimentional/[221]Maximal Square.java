package dp.TwoDimentional;

//leetcode submit region begin(Prohibit modification and deletion)
class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        //dp[i][j] =>the side length of the largest squre containing matrix[i][j] as the right-bottom coner

        //dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j]=1;
                }
            }
        }
        int maxArea =0;
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
            }
        }

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                maxArea = Math.max(maxArea,dp[i][j]*dp[i][j]);
            }
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
