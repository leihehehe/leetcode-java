package dp;

class MaxProfitKTransactionsSolution1 {
    int[][][] memo;
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        memo = new int[n][k+1][2];
        for(int[][] mem1:memo){
            for(int[] mem2:mem1){
                mem2[0] = -1;
                mem2[1] = -1;
            }

        }
        return dfs(prices, n-1, 0, k);
    }

    public int dfs(int[] prices, int i, int hold, int k){
        if(k<0){
            return Integer.MIN_VALUE;
        }
        //表示在第0天以前，还没开始的时候
        //因此不可能有hold的情况
        if(i<0){
            return hold==1? Integer.MIN_VALUE : 0;
        }
        if(memo[i][k][hold]!=-1){
            return memo[i][k][hold];
        }
        if(hold==1){
            //卖一次算k
            memo[i][k][hold] = Math.max(dfs(prices,i-1,1,k),dfs(prices, i-1, 0,k)-prices[i]);
        }else{
            //k-1表示已经用掉了一次
            memo[i][k][hold] = Math.max(dfs(prices,i-1,0,k),dfs(prices,i-1,1,k-1)+prices[i]);
        }
        return memo[i][k][hold];
    }
}

class MaxProfitKTransactionsSolution2 {
    int[][][] memo;
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        memo = new int[n+1][k+2][2];
        //这里i是从0开始的，j也是0
        for(int i = 0;i<n;i++){
            memo[i][0][0] = Integer.MIN_VALUE;
            memo[i][0][1] = Integer.MIN_VALUE;
        }
        //这里j从0开始
        for(int j = 0;j<=k;j++){
            memo[0][j][1] = Integer.MIN_VALUE;
            memo[0][j][0] = 0;
        }
        for(int i =0;i<n;i++){
            for(int j = 0;j<=k;j++){
                //卖一次算k
                memo[i+1][j+1][1] = Math.max(memo[i][j+1][1],memo[i][j+1][0]-prices[i]);
                memo[i+1][j+1][0] = Math.max(memo[i][j+1][0],memo[i][j][1]+prices[i]);
            }
        }
        return memo[n][k+1][0];
    }

}
