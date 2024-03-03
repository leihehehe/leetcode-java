package dp;

/**
 * Leetcode 122
 */
class MaxProfitSolution1 {
    int[][] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new int[n][2];
        for(int[] m:memo){
            m[0] = -1;
            m[1] = -1;
        }
        return dfs(prices, n-1, 0);
    }

    public int dfs(int[] prices, int i, int hold){
        //表示在第0天以前，还没开始的时候
        //因此不可能有hold的情况
        if(i<0){
            return hold==1? Integer.MIN_VALUE : 0;
        }
        if(memo[i][hold]!=-1){
            return memo[i][hold];
        }
        if(hold==1){
            memo[i][hold] = Math.max(dfs(prices,i-1,1),dfs(prices, i-1, 0)-prices[i]);
        }else{
            memo[i][hold] = Math.max(dfs(prices,i-1,0),dfs(prices,i,1)+prices[i]);
        }
        return memo[i][hold];
    }
}
class MaxProfitSolution2 {
    int[][] memo;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new int[n+1][2];
        memo[0][1] = Integer.MIN_VALUE;
        memo[0][0] = 0;

        for(int i = 0;i<n;i++){
            memo[i+1][1] = Math.max(memo[i][1],memo[i][0]-prices[i]);
            memo[i+1][0] = Math.max(memo[i][0],memo[i][1]+prices[i]);
        }
        return memo[n][0];
    }

}