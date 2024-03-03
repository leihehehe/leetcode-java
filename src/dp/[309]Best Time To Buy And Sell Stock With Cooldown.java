package dp;



class MaxProfitCoolDownSolution1 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        memo = new int[n][2];
        for(int[] m:memo){
            m[0] = -1;
            m[1] = -1;
        }
        return dfs(prices,n-1,0);
    }
    int[][] memo;
    public int dfs(int[] prices, int i, int hold){
        if(i<0){
            return hold==1?Integer.MIN_VALUE:0;
        }
        if(memo[i][hold]!=-1){
            return memo[i][hold];
        }
        if(hold==1){
            //昨天就有/前天卖了，这里是i-2是因为sell才算冷冻期
            return memo[i][hold] = Math.max(dfs(prices,i-1,1),dfs(prices,i-2,0) - prices[i]);
        }
        //昨天就没有/昨天买了，这里是i-1是因为buy不算冷冻期
        return memo[i][hold] = Math.max(dfs(prices,i-1,0), dfs(prices, i-1, 1)+prices[i]);
    }
}
class MaxProfitCoolDownSolution2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] memo = new int[n+2][2];
        //这里+2了 -> -1+2 = 1
        memo[1][1] = Integer.MIN_VALUE;
        memo[1][0] = 0;
        for(int i = 0;i<n;i++){
            //昨天就有/前天卖了，这里是i-2是因为sell才算冷冻期
            memo[i+2][1] = Math.max(memo[i+1][1],memo[i][0] - prices[i]);
            //昨天就没有/昨天买了，这里是i-1是因为buy不算冷冻期
            memo[i+2][0] = Math.max(memo[i+1][0], memo[i+1][1] + prices[i]);
        }

        return memo[n+1][0];
    }

}
