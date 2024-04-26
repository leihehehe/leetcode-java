package dp;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class CountGoodStringsSolution1 {
    private final static int MODULE = (int)1e9+7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        memo = new int[high+1];
        Arrays.fill(memo,-1);
        int res = 0;
        for(int i = high;i>=low;i--){
            res = (res + dfs(zero,one,i))% MODULE;
        }
        return res% MODULE;
    }
    //curLen starts with `high`
    int[] memo;
    public int dfs(int zero, int one, int curLen){
        if(curLen==0) return 1;
        if(curLen<0) return 0;
        if(memo[curLen]!=-1) return memo[curLen];
        int res = 0;
        //choose one
        res = (res + dfs(zero,one,curLen-one))% MODULE;
        //choose zero
        res = (res + dfs(zero,one,curLen-zero))% MODULE;
        return memo[curLen] = res ;
    }

}
class CountGoodStringsSolution2 {
    private final static int MODULE = (int)1e9+7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] memo = new int[high+1];
        int ans = 0;
        memo[0] = 1;
        for(int i = 1;i<=high;i++){
            if(i>=one)
                memo[i] = (memo[i] + memo[i-one])%MODULE;
            if(i>=zero)
                memo[i] =( memo[i] + memo[i-zero])%MODULE;
            if(i>=low)
                ans = (ans + memo[i])% MODULE;
        }
        return ans% MODULE;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
