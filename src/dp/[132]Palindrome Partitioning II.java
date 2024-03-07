package dp;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class MinCutSolution1 {
    private Boolean[][] p;
    private int[][] dp;
    public int minCut(String s) {
        int n = s.length();
        p = new Boolean[n][n];
        dp = new int[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return dfs(s,0,n-1);
    }
    public boolean isPalindrome(String s, int l, int r){
        if(l>=r){
            return true;
        }
        if(p[l][r]!=null) return p[l][r];
        if(s.charAt(l) == s.charAt(r)){
            return p[l][r] = isPalindrome(s,l+1,r-1);
        }
        return false;
    }
    public int dfs(String s, int i, int j){
        if(i==j || isPalindrome(s, i, j)){
            return 0;
        }
        if(i>j){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int res = Integer.MAX_VALUE;
        for(int k = i;k<=j;k++){
            if(isPalindrome(s,i,k)){
                res = Math.min(res, 1 + dfs(s, k+1, j));
            }
        }
        return dp[i][j] = res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
