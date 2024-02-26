package dp;
class LCSSolution1 {
    Integer[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        memo = new Integer[m][n];
        return dfs(text1,text2,text1.length()-1,text2.length()-1);
    }
    public int dfs(String text1, String text2, int i, int j){
        if(i<0 || j<0){
            return 0;
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        if(text1.charAt(i) == text2.charAt(j)){
            //把这两个选做公共子序列的一部分
            memo[i][j] = dfs(text1,text2,i-1,j-1)+1;
        }else{
            //这里不用+1了，因为i和j上的数字都相等才能算公共子序列的长度+1
            //选其中一个作为公共子序列的部分，但是是另一个子问题了。
            memo[i][j] = Math.max(dfs(text1,text2,i,j-1),dfs(text1,text2,i-1,j));
        }
        return memo[i][j];
    }
}
class LCSSolution2 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] memo = new int[m+1][n+1];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    //把这两个选做公共子序列的一部分
                    memo[i+1][j+1] = memo[i][j]+1;
                }else{
                    memo[i+1][j+1] = Math.max(memo[i+1][j],memo[i][j+1]);
                }
            }
        }
        return memo[m][n];
    }
}
class LCSSolution3 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] memo = new int[n+1];
        int temp = 0;
        for(int i = 0;i<m;i++){
            int prev = 0;
            for(int j = 0;j<n;j++){
                temp = memo[j+1];
                if(text1.charAt(i) == text2.charAt(j)){
                    //把这两个选做公共子序列的一部分
                    memo[j+1] = prev+1;
                }else{
                    memo[j+1] = Math.max(memo[j],memo[j+1]);
                }
                prev = temp;
            }
        }
        return memo[n];
    }
}

