package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        //dp[i] -> cost of reach index i
        int[] dp = new int[cost.length+1];
        //dp[i] = Math.min(two step cost, one step cost)
        //initilization:
        dp[0] = 0;
        dp[1]= Math.min(dp[0]+cost[0],0);

        for(int i = 2;i<=cost.length;i++){
            dp[i] = Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
        }
        return dp[cost.length];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
