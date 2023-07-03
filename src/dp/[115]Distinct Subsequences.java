package dp;

/**
 * Leetcode 115
 */
class DistinctSubsequences {

    public int numDistinctMethod1(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        //当t是空字符
        for(int i = 0;i<=m;i++) dp[i][0] = 1;
        for(int i =1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
    /**
     * Method 2: two-dimensional array dp
     * Time complexity: O(MN)
     * Space complexity: O(MN)
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) return 0;
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) dp[i][0] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = dp[i - 1][j] + (s.charAt(i-1) == t.charAt(j-1) ? dp[i - 1][j - 1] : 0);
            }
        }
        return dp[m][n];
    }

    /**
     * Method 2: one-dimensional array dp - positive order
     * Time complexity: O(MN)
     * Space complexity: O(N)
     * @param s
     * @param t
     * @return
     */
    public int numDistinctMethod2(String s, String t) {
        if(s.length() < t.length()) return 0;
        int m = s.length(), n = t.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        int pre =1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                int nextPre = dp[j];
                dp[j] = dp[j] + (s.charAt(i-1) == t.charAt(j-1) ? pre : 0);
                pre = nextPre;
            }
            pre = 1;
        }
        return dp[n];
    }

    /**
     * Method 3: one-dimensional array dp - negative order
     * Time complexity: O(MN)
     * Space complexity: O(N)
     * @param s
     * @param t
     * @return
     */
    public int numDistinctMethod3(String s, String t) {
        if(s.length() < t.length()) return 0;
        int m = s.length(), n = t.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = n; j >0; j--){
                dp[j] = dp[j] + (s.charAt(i-1) == t.charAt(j-1) ? dp[j - 1] : 0);
            }
        }
        return dp[n];
    }
}
