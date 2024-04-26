package dp;

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

/**
 * Weekly Contest 170
 * Hard(medium in practice)
 */
class MinInsertionsSolution1 {
    int[][] memo;
    public int minInsertions(String s) {
        int n = s.length();
        memo = new int[n][n];
        for(int i = 0;i<n;i++) Arrays.fill(memo[i],-1);
        return dfs(s,0,n-1);
    }
    public int dfs(String s, int i, int j){
        if(i>=j){
            return 0;
        }
        if(memo[i][j]!=-1) return memo[i][j];
        if(s.charAt(i)==s.charAt(j)){
            return memo[i][j] = dfs(s,i+1,j-1);
        }
        return memo[i][j] = Math.min(dfs(s,i+1,j)+1,dfs(s,i,j-1)+1);
    }
}
class MinInsertionsSolution2 {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] memo = new int[n][n];

        for(int i  = n-1;i>=0;i--){
            for(int j = i;j<n;j++){
                if(i>=j){
                    memo[i][j] = 0;
                } else if(s.charAt(i)==s.charAt(j)){
                    memo[i][j] = memo[i+1][j-1];
                }else{
                    memo[i][j] = Math.min(memo[i+1][j]+1,memo[i][j-1]+1);
                }
            }
        }
        return memo[0][n-1];
    }

}
class MinInsertionsSolution3 {
    public int minInsertions(String s) {
        int n = s.length();
        int[] memo = new int[n];

        for(int i  = n-1;i>=0;i--){
            int prev = 0;
            for(int j = i;j<n;j++){
                int temp = memo[j];
                if(i>=j){
                    memo[j] = 0;
                } else if(s.charAt(i)==s.charAt(j)){
                    memo[j] = prev;
                }else{
                    memo[j] = Math.min(memo[j]+1,memo[j-1]+1);
                }
                prev = temp;
            }
        }
        return memo[n-1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
