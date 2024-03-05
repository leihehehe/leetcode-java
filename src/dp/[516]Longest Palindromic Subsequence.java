package dp;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestPalindromeSubseqSolution1 {
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];
        for(int[] d : dp) Arrays.fill(d,-1);
        return dfs(s,0,n-1);
    }
    public int dfs(String s, int i, int j){
        if(i==j) return 1;
        if(i>j){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = dfs(s,i+1,j-1) + 2;
        }else{
            return dp[i][j] = Math.max(dfs(s,i+1,j),dfs(s,i,j-1));
        }
    }
}
class LongestPalindromeSubseqSolution2 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        //i必须小于j
        for(int i = n-1;i>=0;i--){
            dp[i][i] = 1;
            for(int j = i+1;j<n;j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];
    }

}
class LongestPalindromeSubseqSolution3 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] dp = new int[n];
        //i必须小于j
        for(int i = n-1;i>=0;i--){
            dp[i] = 1;
            int prev = 0;
            for(int j = i+1;j<n;j++){
                int cur = dp[j];
                if(s.charAt(i) == s.charAt(j)){
                    dp[j] = prev+2;
                }else{
                    dp[j] = Math.max(dp[j],dp[j-1]);
                }
                prev = cur;
            }
        }

        return dp[n-1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
