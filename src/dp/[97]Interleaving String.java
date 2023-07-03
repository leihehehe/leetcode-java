package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        // dp[i][j]表示s1的前i个字符和s2的前j个字符是否能构成s3的前i+j个字符
        // if(s1[i-1] == s3[i+j-1]) dp[i][j] = dp[i-1][j]
        // if(s2[j-1] == s3[i+j-1]) dp[i][j] = dp[i][j-1]
        int m = s1.length();
        int n = s2.length();
        if(m + n != s3.length()) return false;
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 1; i <= m; i++) dp[i][0] = s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0];
        for(int j = 1; j <= n; j++) dp[0][j] = s2.charAt(j-1) == s3.charAt(j-1) && dp[0][j-1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                // i匹配了
                if(s1.charAt(i-1) == s3.charAt(i+j-1)) dp[i][j] = dp[i-1][j];
                // j匹配了
                if(s2.charAt(j-1) == s3.charAt(i+j-1)) dp[i][j] = dp[i][j] || dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
