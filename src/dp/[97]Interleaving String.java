package dp;

//leetcode submit region begin(Prohibit modification and deletion)

class IsInterleaveSolution1 {
    Boolean[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        memo = new Boolean[n][m];
        return dfs(s1, s2, s3, n-1, m-1);
    }
    public boolean dfs(String s1, String s2, String s3, int i, int j){
        if(i< 0){
            return s2.substring(0,j+1).equals(s3.substring(0,j+1));
        }
        if(j< 0){
            return s1.substring(0,i+1).equals(s3.substring(0,i+1));
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        //we choose one at a time
        boolean res = false;
        if(c1==s3.charAt(i+j+1)){
            res = dfs(s1, s2, s3, i-1, j);
        }
        if(c2==s3.charAt(i+j+1)){
            res = res || dfs(s1, s2, s3, i, j-1);
        }
        //因为这道题保持了相对顺序，也就是说现在遍历到的s3字符，一定来自于你现在所遍历到的i和j其中一个
        memo[i][j] = res;
        return res;
    }
}
class IsInterleaveSolution2 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (n + m != s3.length()) return false;
        boolean[][] memo = new boolean[n+1][m+1];
        memo[0][0]=true;
        for(int i = 0;i<n;i++){
            //这里的s1.charAt(i) == s3.charAt(i)很关键
            memo[i+1][0] = s1.substring(0,i+1).equals(s3.substring(0,i+1));
        }
        for(int j = 0;j<m;j++){
            memo[0][j+1] = s2.substring(0,j+1).equals(s3.substring(0,j+1));
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                boolean res = false;
                if(s1.charAt(i)==s3.charAt(i+j+1)){
                    res = memo[i][j+1];
                }
                if(s2.charAt(j)==s3.charAt(i+j+1)){
                    res = res || memo[i+1][j];
                }
                memo[i+1][j+1] = res;
            }
        }
        return memo[n][m];
    }
}

class IsInterleaveSolution3 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (n + m != s3.length()) return false;
        boolean[] memo = new boolean[m+1];
        memo[0]=true;
        for(int j = 0;j<m;j++){
            memo[j+1] = s2.substring(0,j+1).equals(s3.substring(0,j+1));
        }
        for(int i = 0;i<n;i++){
            memo[0] = s1.substring(0,i+1).equals(s3.substring(0,i+1));
            for(int j = 0;j<m;j++){
                boolean res = false;
                if(s1.charAt(i)==s3.charAt(i+j+1)){
                    res = memo[j+1];
                }
                if(s2.charAt(j)==s3.charAt(i+j+1)){
                    res = res || memo[j];
                }
                memo[j+1] = res;
            }
        }
        return memo[m];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
