package weeklyContest.dp;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Weekly Contest 229
 */
class MaximumScoreSolution1 {
    Integer[][] memo;
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        memo = new Integer[n][m];
        return dfs(nums,0,multipliers,0);
    }
    /**
     * 这里只用二维数组来表示即可，不需要同时有两个状态，因为l可以推出j
     */
    public int dfs(int[] nums, int l, int[] multipliers, int k){

        if(k>=multipliers.length){
            return 0;
        }
        if(memo[l][k]!=null){
            return memo[l][k];
        }
        int r = nums.length-k+l-1;
        return memo[l][k] = Math.max(dfs(nums,l+1,multipliers,k+1)+nums[l]*multipliers[k]
                ,dfs(nums,l,multipliers,k+1)+nums[r]*multipliers[k]);

    }
}
class MaximumScoreSolution2 {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[][] memo = new int[n + 1][m + 1];
        // 对应递归：
        // if(k>=multipliers.length){
        // return 0;
        // }
        for (int i = 0; i < n; i++) {
            memo[i][m] = 0;
        }

        for (int l = n - 1; l >= 0; l--) {
            for (int k = m - 1; k >= 0; k--) {
                int r = nums.length - k + l - 1;
                //递归中不用判断r的范围是因为我们在入口处判断了k的范围，k限制了l和r
                //这里需要判断r的范围，因为即使k限制了范围，但l并没有被k限制，所以可能造成r越界
                //越界的情况本身就是不合法的，所以无需计算答案
                if (r >= 0 && r < n) {
                    memo[l][k] = Math.max(memo[l + 1][k + 1] + nums[l] * multipliers[k],
                            memo[l][k + 1] + nums[r] * multipliers[k]);
                }

            }
        }
        return memo[0][0];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
