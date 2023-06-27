package dp;

import java.util.List;

/**
 * Leetcode 120
 */
class Triangle {
    /**
     * TIME: O(n^2)
     * SPACE: O(n^2)
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        //dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j)
        dp[0][0]=triangle.get(0).get(0);
        for(int i = 1;i<m;i++){
            dp[i][0] = dp[i-1][0]+triangle.get(i).get(0);
            for(int j = 1; j< i; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }
        int res=Integer.MAX_VALUE;
        for(int path : dp[m-1]){
            res = Math.min(res,path);
        }
        return res;
    }

    /**
     * Optimized method
     * TIME: O(n^2)
     * SPACE: O(n)
     * @param triangle
     * @return
     */
    public int minimumTotalOptimized(List<List<Integer>> triangle) {
        int m = triangle.size();

        int[] dp = new int[m];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1;i<m;i++){
            dp[i] = dp[i-1] + triangle.get(i).get(i);
            for(int j = i-1; j>0; j--){
                dp[j] = Math.min(dp[j], dp[j-1]) + triangle.get(i).get(j);
            }
            dp[0] = dp[0]+triangle.get(i).get(0);
        }
        int res=Integer.MAX_VALUE;
        for(int path : dp){
            res = Math.min(res,path);
        }
        return res;
    }
}
