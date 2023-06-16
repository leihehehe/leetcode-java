package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] dp = new int[s.length()+1];
        int maxLen = 0;
        for(int i = 1;i<=s.length();i++){
            char c = s.charAt(i-1);
            if(c=='('){
                stack.addLast(i);
            }else{
                if(!stack.isEmpty()){
                    dp[i] = dp[i-1]+2;
                    int leftIndex = stack.pollLast();
                    dp[i] += dp[leftIndex-1];
                    maxLen= Math.max(maxLen,dp[i]);
                }
            }
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
