package dp;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

/**
 * Weekly Contest 229
 * Hard
 */
class LongestPalindromeSolution1 {
    int[][] memo;
    int m;
    int ans = 0;
    public int longestPalindrome(String word1, String word2) {
        m = word1.length();
        int n = word2.length();
        String word = word1+word2;
        memo = new int[m+n][m+n];
        for(int i = 0;i<m+n;i++) Arrays.fill(memo[i],-1);
        dfs(word,0,word.length()-1);
        return ans;
    }
    public int dfs(String word, int i, int j){
        if(i>j){
            return 0;
        }
        if(i==j){
            return 1;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        int res = 0;
        if(word.charAt(i) == word.charAt(j)){
            res = dfs(word,i+1,j-1)+2;
            //写在这个两个字符相等的if条件下面是为了确保我们只考虑那些作为回文序列一部分的字符对，从而更新答案
            if(i<m && j>=m){
                ans = Math.max(res,ans);
            }
        }
        res = Math.max(res,Math.max(dfs(word,i+1,j),dfs(word,i,j-1)));
        return memo[i][j] = res;
    }
}
class LongestPalindromeSolution2 {

    public int longestPalindrome(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        String word = word1+word2;
        int[][] memo = new int[m+n+1][m+n+1];
        int ans = 0;
        for(int i = m+n-1;i>=0;i--){
            for(int j = 0;j<m+n;j++){
                if(i>j){
                    memo[i][j+1] = 0;
                }else if(i==j){
                    memo[i][j+1] = 1;
                }else{
                    if(word.charAt(i) == word.charAt(j)){
                        memo[i][j+1] = memo[i+1][j]+2;
                        //写在这个两个字符相等的if条件下面是为了确保我们只考虑那些作为回文序列一部分的字符对，从而更新答案
                        if(i<m && j>=m){
                            ans = Math.max(memo[i][j+1],ans);
                        }
                    }
                    memo[i][j+1] = Math.max(memo[i][j+1],Math.max(memo[i+1][j+1],memo[i][j]));
                }

            }
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
