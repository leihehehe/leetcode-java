package dp;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class GetMoneyAmountSolution1 {
    int[][] dp;
    public int getMoneyAmount(int n) {
        dp = new int[n+1][n+1];
        for(int i = 0;i<n;i++) Arrays.fill(dp[i], -1);
        return dfs(1,n);
    }

    public int dfs(int l, int r){
        if(l>r){
            return Integer.MAX_VALUE;
        }
        if(l==r)
            return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        int amount = Integer.MAX_VALUE;
        for(int i = l;i<=r;i++){
            amount = Math.min(amount, Math.max(dfs(l,i-1)+i,dfs(i+1,r)+i));
        }
        return dp[l][r] = amount;
    }
}

class GetMoneyAmountSolution2 {
    int[][] dp;
    public int getMoneyAmount(int n) {
        dp = new int[n+2][n+1];
        for(int l = n-1;l>=1;l--){
            for(int r = l;r<=n;r++){
                if(l==r){
                    dp[l][r] = 0;
                }else if(l>r){
                    dp[l][r] = Integer.MAX_VALUE;
                }else{
                    int amount = Integer.MAX_VALUE;
                    for(int i = l;i<=r;i++){
                        amount = Math.min(amount, Math.max(dp[l][i-1]+i,dp[i+1][r]+i));
                    }
                    dp[l][r] = amount;
                }

            }
        }
        return dp[1][n];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
