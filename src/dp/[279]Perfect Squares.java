package dp;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class NumSquaresSolution1 {
    int inf = 10001;
    Integer[][] memo;
    public int numSquares(int n) {
        int t = (int) Math.sqrt(n);
        memo = new Integer[t+1][n+1];
        return dfs(t, t, n);
    }
    //完全背包
    public int dfs(int n, int i, int target){
        if(i==0){
            if(target==0) return 0;
            else return inf;
        }
        if(memo[i][target]!=null){
            return memo[i][target];
        }
        //不选
        int notChosen = dfs(n, i-1, target);
        if(i*i>target){
            memo[i][target]= notChosen;
            return notChosen;
        }
        int res = Math.min(notChosen, dfs(n,i,target-i*i)+1);
        memo[i][target] = res;
        return res;
    }
}
class NumSquaresSolution2 {
    int inf = 10001;

    public int numSquares(int n) {
        int t = 1;
        while(t*t<=n){
            t++;
        }
        int[][] memo = new int[t+2][n+1];
        Arrays.fill(memo[1], inf);
        memo[1][0] = 0;
        for(int i = 1;i<=t;i++){
            for(int j = 0;j<=n;j++){
                if(i*i>j){
                    memo[i+1][j]= memo[i][j];
                }else{
                    memo[i+1][j] = Math.min(memo[i][j], memo[i+1][j-i*i]+1);
                }
            }
        }

        return memo[t+1][n];
    }

}
class NumSquaresSolution3 {
    int inf = 10001;

    public int numSquares(int n) {
        int t = 1;
        while(t*t<=n){
            t++;
        }
        int[] memo = new int[n+1];
        Arrays.fill(memo, inf);
        memo[0] = 0;
        for(int i = 1;i<=t;i++){
            for(int j = 0;j<=n;j++){
                if(i*i<=j){
                    memo[j] = Math.min(memo[j], memo[j-i*i]+1);
                }
            }
        }

        return memo[n];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
