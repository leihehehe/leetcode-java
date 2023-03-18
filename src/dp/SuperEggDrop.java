package dp;

import java.util.Arrays;

/**
 * Leetcode 887
 */
public class SuperEggDrop {
    /**
     * Method 1: iterative dp
     * @param k
     * @param n
     * @return
     */
    public int superEggDrop(int k, int n) {
        //dp[i][j]=> minimum move when i eggs, j floors
        int[][] dp = new int[k+1][n+1];
        //dp[i][j] = 1. egg broken: dp[i-1][f-1]+1; 2. egg not broken: dp[i][j-k]+1;
        for(int j =0;j<=n;j++) dp[1][j] = j;

        for(int i =2;i<=k;i++){
            for(int j = 1;j<=n;j++){
                int min =Integer.MAX_VALUE;
                for(int x = 1;x<=j;x++){
                    //egg broken
                    int worstCase = Math.max(dp[i-1][x-1],dp[i][j-x])+1;
                    min = Math.min(worstCase,min);
                }
                dp[i][j]=min;
            }
        }
        return dp[k][n];
    }

    /**
     * Method 2: optimized iterative dp+ binary search
     * @param k
     * @param n
     * @return
     */
    public int superEggDropMethod2(int k, int n) {
        //dp[i][j]=> minimum move when i eggs, j floors
        int[][] dp = new int[k+1][n+1];
        //dp[i][j] = 1. egg broken: dp[i-1][f-1]+1; 2. egg not broken: dp[i][j-k]+1;
        for(int j =0;j<=n;j++) dp[1][j] = j;

        for(int i =2;i<=k;i++){
            for(int j = 1;j<=n;j++){
                int min =Integer.MAX_VALUE;
                int l =1, r = j;
                while(l<=r){
                    int mid = l+(r-l)/2;
                    int broken = dp[i-1][mid-1]+1;
                    int notBroken = dp[i][j-mid]+1;
                    if(broken>notBroken){
                        r = mid-1;
                        min = Math.min(broken,min);
                    }
                    else{
                        l = mid+1;
                        min = Math.min(notBroken,min);
                    }
                }

                dp[i][j]=min;
            }
        }
        return dp[k][n];
    }

    /**
     * Method 3: recursive dp
     */
    int[][] memo;
    public int superEggDropMethod3(int k, int n) {
        //dp[i][j] => minimum number of moves(times of dropping an egg) by using i eggs for j floors
        //dp[i][j] = dp[i-1][j-x]
        memo = new int[k + 1][n + 1];
        for(int[] row:memo) Arrays.fill(row,-666);
        return dp(k,n);
    }

    public int dp(int k, int n){
        //only one egg, need test all floors
        if(k == 1) return n;
        //no floor, no move
        if(n == 0) return 0;
        if(memo[k][n]!=-666) return memo[k][n];
        int res = Integer.MAX_VALUE;
        for(int i = 1;i<=n;i++){
            //dp(k,n-1) egg -> not broken, search for higher floor
            //dp(k-1,i-1) egg -> broken, search for lower floor
            // +1 current floor
            res = Math.min(res,Math.max(dp(k,n-i),dp(k-1,i-1))+1);
        }
        memo[k][n]=res;
        return res;
    }

    /**
     * Method 4: optimized recursive dp
     * @param k
     * @param n
     * @return
     */
    public int superEggDropMethod4(int k, int n) {
        //dp[i][j] => minimum number of moves(times of dropping an egg) by using i eggs for j floors
        //dp[i][j] = dp[i-1][j-x]
        memo = new int[k + 1][n + 1];
        for(int[] row:memo) Arrays.fill(row,-666);
        return dpMethod4(k,n);
    }

    public int dpMethod4(int k, int n){
        //only one egg, need test all floors
        if(k == 1) return n;
        //no floor, no move
        if(n == 0) return 0;
        if(memo[k][n]!=-666) return memo[k][n];
        int res = Integer.MAX_VALUE;
        int l =1, r= n;
        while(l<=r){
            int mid = l+(r-l)/2;
            int broken = dpMethod4(k-1,mid-1);
            int notBroken = dpMethod4(k,n-mid);
            if(broken>notBroken){
                r = mid-1;
                res = Math.min(res,broken+1);
            }else{
                l = mid +1;
                res = Math.min(res,notBroken+1);
            }
        }
        memo[k][n]=res;
        return res;
    }

}
