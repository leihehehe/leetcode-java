package dp;

/**
 * Another solution for this problem is in "StackAndDeque"
 */
//leetcode submit region begin(Prohibit modification and deletion)
class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()+1];
        int left = 0;
        int maxLen = 0;
        for(int i = 1;i<=s.length();i++){
            char c = s.charAt(i-1);
            if(c=='('){
                left++;
            }else{
                if(left>0){
                    left--;
                    dp[i] = dp[i-1]+2;
                    dp[i]+=dp[i-dp[i]];
                    maxLen = Math.max(maxLen,dp[i]);
                }
            }
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
