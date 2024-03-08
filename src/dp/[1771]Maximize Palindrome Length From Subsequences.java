package dp;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestPalindromeSolution1 {
    int[][] memo;
    int m,n;
    int ans = 0;
    public int longestPalindrome(String word1, String word2) {
        m = word1.length();
        n = word2.length();
        memo= new int[m+n][m+n];
        for(int i = 0;i<m+n;i++) Arrays.fill(memo[i],-1);
        String word = word1+ word2;
        dfs(word,0,m+n-1);
        return ans;
    }

    public int dfs(String word, int i, int j){
        if(i>j) return 0;
        if(i==j) return 1;
        if(memo[i][j]!=-1) return memo[i][j];
        if(word.charAt(i) == word.charAt(j)){
            memo[i][j] = dfs(word, i+1, j-1)+2;
            if(i<m && j>=m){
                ans = Math.max(ans,memo[i][j]);
            }
            return memo[i][j];
        }
        return memo[i][j] = Math.max(dfs( word, i+1, j),dfs(word, i, j-1)) ;

    }
}
class LongestPalindromeSolution2 {

    public int longestPalindrome(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo= new int[m+n][m+n];
        int res = 0;
        String word = word1+word2;
        for(int i = m+n-1;i>=0;i--){
            memo[i][i] = 1;
            for(int j = i+1;j<m+n;j++){
                if(word.charAt(i) == word.charAt(j)){
                    memo[i][j] = memo[i+1][j-1] + 2;
                    if(i<m && j>=m){
                        res = Math.max(res,memo[i][j]);
                    }
                }else{
                    memo[i][j] = Math.max(memo[i+1][j],memo[i][j-1]);
                }
            }
        }
        return res;

    }


}
//leetcode submit region end(Prohibit modification and deletion)
