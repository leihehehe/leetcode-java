package dp;

class MinFallingPathSumII {
    public int minFallingPathSum(int[][] grid) {
        //只能左下或右下走，但不一定只隔一个位置
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        //initilization for the first row
        int minSum = Integer.MAX_VALUE;
        int minIndex = -1;
        int secMinSum = Integer.MAX_VALUE;
        for(int j = 0;j<n;j++){
            dp[0][j] = grid[0][j];
            if(dp[0][j]<minSum){
                secMinSum = minSum;
                minSum = dp[0][j];
                minIndex = j;
            }else if(dp[0][j]<secMinSum){
                secMinSum = dp[0][j];
            }
        }


        for(int i =1;i<m;i++){
            int curMinIndex = -1;
            int curMinSum = Integer.MAX_VALUE;
            int curSecMinSum = Integer.MAX_VALUE;
            for(int j = 0;j<n;j++){
                if(minIndex==j) dp[i][j] = secMinSum+grid[i][j];
                else dp[i][j] = minSum+grid[i][j];
                if(dp[i][j]<curMinSum){
                    curSecMinSum = curMinSum;
                    curMinSum = dp[i][j];
                    curMinIndex = j;
                }else if(dp[i][j]<curSecMinSum){
                    curSecMinSum = dp[i][j];
                }
            }
            minSum = curMinSum;
            minIndex = curMinIndex;
            secMinSum = curSecMinSum;
        }

        return minSum;
    }
}