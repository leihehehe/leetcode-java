package dp;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class MinScoreTriangulationSolution1 {
    int[][] dp;
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        dp = new int[n][n];
        for(int i = 0 ;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return dfs(values,0,n-1);
    }
    public int dfs(int[] values, int i, int j){
        if(i+1==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int res =Integer.MAX_VALUE;
        for(int k = i+1;k<j;k++){
            res = Math.min(res, dfs(values,i,k)+dfs(values,k,j) + values[i]*values[j]*values[k]);
        }
        return dp[i][j] = res;
    }
}
class MinScoreTriangulationSolution2 {
    int[][] dp;
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        dp = new int[n][n];
        for(int i = 0 ;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<n;j++){
                if(i+1==j){
                    dp[i][j] = 0;
                    continue;
                }
                for(int k = i+1;k<j;k++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j] + values[i]*values[j]*values[k]);
                }
            }
        }
        return dp[0][n-1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
