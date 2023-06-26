package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i = 0;i<stones.length;i++){
            sum+=stones[i];
        }
        int target = sum/2;
        //dp[i][j] -> 前面[0..len]的石头选择放进去，
        //dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i])
        int[][] dp = new int[stones.length][target+1];
        for(int i = 0;i<=target;i++){
            if(stones[0]<=i){
                dp[0][i] = stones[0];
            }
        }
        //initialization for stones
        for(int i = 1;i<stones.length;i++){
            for(int j = 1;j<=target;j++){
                if(stones[i]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-stones[i]]+stones[i]);
                }
            }
        }
        return sum - dp[stones.length-1][target]*2;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
