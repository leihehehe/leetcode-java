package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        //dp[l][r]是以s[l][r]为范围的最大长度的回文子串
        int maxLen = Integer.MIN_VALUE;
        int maxL = 0,maxR = 0;
        for(int len = 1;len<=n;len++){
            for(int l = 0;l+len-1<n;l++){
                int r = l+len-1;
                if(len==1) dp[l][r]=1;
                    //当len=2的时候也要考虑进去。
                else if(len==2) dp[l][r]=s.charAt(l)==s.charAt(r)?2:0;
                else if(s.charAt(l)==s.charAt(r) && ( dp[l + 1][r - 1] > 0)){
                    dp[l][r] = dp[l+1][r-1]+2;
                }else{
                    dp[l][r] = 0;
                }
                if(dp[l][r]>maxLen){
                    maxLen=dp[l][r];
                    maxL = l;
                    maxR = r;
                }
            }
        }
        return s.substring(maxL,maxR+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
