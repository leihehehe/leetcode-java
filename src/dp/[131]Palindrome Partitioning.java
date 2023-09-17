package dp;

import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class PalindromePartitioning {
    boolean[][] dp;
    public List<List<String>> partition(String s) {
        //dp[i][j]->区间i..j的字符串是否是palindrome?
        int n = s.length();
        dp = new boolean[n][n];
        for(int len = 1;len<=n;len++){
            for(int i = 0;i+len<=n;i++){
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (len <= 2) || dp[i + 1][j - 1];
                }
            }
        }
        backtrack(s,0);
        return res;
    }
    List<List<String>> res = new LinkedList<>();
    LinkedList<String> path = new LinkedList<>();
    public void backtrack(String s, int start){
        if(start==s.length()){
            res.add(new LinkedList<>(path));
            return;
        }
        for(int i = start;i<s.length();i++){
            String str = s.substring(start,i+1);
            //check if it is paloinedrome
            if(!dp[start][i]){
                continue;
            }
            path.addLast(str);
            backtrack(s,i+1);
            path.removeLast();
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
