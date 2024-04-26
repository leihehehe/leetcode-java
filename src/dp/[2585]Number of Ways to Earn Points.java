package dp;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Hard
 * Weekly Contest 335
 */
class WaysToReachTargetSolution1 {
    int[][] memo;
    final static int MOD = 1000000007;
    public int waysToReachTarget(int target, int[][] types) {
        //type i
        memo = new int[types.length][target+1];
        for(int[] m:memo) Arrays.fill(m, -1);
        return getWays(types,types.length-1,target);
    }
    public int getWays(int[][] types, int i, int target){
        if(target==0)
            return 1;
        if(target<0)
            return 0;
        if(i<0){
            return 0;
        }
        if(memo[i][target]!=-1) return memo[i][target];
        int count = types[i][0];
        int mark = types[i][1];
        //不选这个来挣分
        int res = getWays(types, i-1, target);
        for(int j = 1;j<=count;j++){
            //选这个来挣分
            res= (res + getWays(types, i-1, target-mark*j)) % MOD;
        }
        memo[i][target]= res;
        return res;
    }
}

class WaysToReachTargetSolution2 {
    int[][] memo;
    final static int MOD = 1000000007;
    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        //type i
        memo = new int[n+1][target+1];
        for(int i = 0;i<n;i++){
            memo[i][0] = 1;
        }
        for(int i = 0;i<n;i++){
            int count = types[i][0];
            int mark = types[i][1];
            //不用当前题
            for(int j = 0; j<target+1;j++){
                memo[i+1][j] = memo[i][j];
                for(int k = 1;k<=count && j-mark*k>=0;k++){
                    //选这个来挣分
                    memo[i+1][j]= (memo[i+1][j] + memo[i][j-mark*k]) % MOD;
                }
            }

        }
        return memo[n][target];
    }
}

class WaysToReachTargetSolution3 {
    final static int MOD = 1000000007;
    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        //type i
        int[] memo = new int[target+1];
        memo[0] = 1;
        for(int i = 0;i<n;i++){
            int count = types[i][0];
            int mark = types[i][1];
            //不用当前题
            for(int j = target; j>=1;j--){
                for(int k = 1;k<=count && j-mark*k>=0;k++){
                    //选这个来挣分
                    memo[j]= (memo[j] + memo[j-mark*k]) % MOD;
                }
            }

        }
        return memo[target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
