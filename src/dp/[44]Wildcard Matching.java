package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int j = 1;j<=n;j++){
            if(p.charAt(j-1)=='*' ) dp[0][j] = dp[0][j-1];
        }
        for(int i =1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(p.charAt(j-1)=='?' || s.charAt(i-1)==p.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                    //*abc
                    //a*
                else if(p.charAt(j-1)=='*'){
                    //作为0个字符或作为n个字符
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
