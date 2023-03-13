package dp;

/**
 * Leetcode 10
 */
public class RegularExpressionMatching {
    /**
     * Time complexity: O(mn)
     * Space complexity: O(mn)
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        //dp[i][j] => s[0..i) can be matched by p[0..j)
        //dp[i-1][j-1]
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        //when both s and p are an empty string
        dp[0][0]=true;
        for(int j = 2;j<=n;j++){
            if(p.charAt(j-1)=='*') dp[0][j] = dp[0][j-2];
        }
        for(int i =1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(p.charAt(j-1)=='*'){
                    if(p.charAt(j-2)=='.' || s.charAt(i-1)==p.charAt(j-2))
                        dp[i][j]=dp[i][j-2] || dp[i-1][j];
                    else
                        dp[i][j] = dp[i][j-2];
                }else if(p.charAt(j-1)=='.')
                    dp[i][j]=dp[i-1][j-1];
                else if(p.charAt(j-1)==s.charAt(i-1))
                    dp[i][j]=dp[i-1][j-1];
            }
        }
        return dp[m][n];
    }
}
