package dp;

/**
 * Leetcode 1143
 */
class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[2][n + 1];
        //公共部分就是前面的空格
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i & 1][j] = dp[(i - 1) & 1][j - 1] + 1;
                } else {
                    //如果不相等的话，就比较前面的数
                    dp[i & 1][j] = Math.max(dp[(i - 1) & 1][j], dp[i & 1][j - 1]);
                }
            }
        }
        return dp[m & 1][n];
    }

    /**
     * dp[2][c+1] optimization
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[2][n+1];
        //公共部分就是前面的空格
        for(int i =1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i&1][j] = dp[(i-1)&1][j-1]+1;
                }else{
                    //如果不相等的话，就比较前面的数
                    dp[i&1][j] = Math.max(dp[(i-1)&1][j],dp[i&1][j-1]);
                }
            }
        }
        return dp[m&1][n];
    }

    /**
     * dp[c+1] optimization
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence3(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n+1];
        //公共部分就是前面的空格

        for(int i =1;i<=m;i++){
            int diagonal = dp[0]; // holds dp[i-1][j-1]
            for(int j = 1;j<=n;j++){
                int temp = dp[j];//holds dp[i-1][j]
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[j] = diagonal+1;
                }else{
                    //如果不相等的话，就比较前面的数
                    dp[j] = Math.max(dp[j],dp[j-1]);
                }
                diagonal = temp;
            }
        }
        return dp[n];
    }
}
