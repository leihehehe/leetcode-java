package dp;

/**
 * Leetcode 712
 */
public class MinimumASCIIDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int n1= s1.length(), n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];

        for(int i = 1;i<=n1;i++) dp[i][0] = dp[i-1][0]+(int)s1.charAt(i-1);
        for(int j = 1;j<=n2;j++) dp[0][j] = dp[0][j-1]+(int)s2.charAt(j-1);
        for(int i =1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                int c1 = s1.charAt(i-1), c2=s2.charAt(j-1);

                if(c1 == c2) dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1]+c1+c2,dp[i-1][j]+c1),dp[i][j-1]+c2);

            }
        }
        return dp[n1][n2];
    }
}
