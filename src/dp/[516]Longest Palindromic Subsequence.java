package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int len=1;len<=n;len++){
            //left和right的区间
            for(int l=0;l+len-1<n;l++){
                int r = l+len-1;
                //当长度为1的时候，一定为palindromic
                if(len==1) dp[l][r] = 1;
                else if(s.charAt(l)==s.charAt(r)) dp[l][r] = dp[l+1][r-1]+2;
                else dp[l][r] = Math.max(dp[l+1][r],dp[l][r-1]);
            }
        }
        return dp[0][s.length()-1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
