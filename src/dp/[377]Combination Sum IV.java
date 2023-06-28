package dp;

/**
 * Leetcode 377
 */
class CombinationSumIV {
    /**
     * TIME: O(N*target)
     * SPACE: O(target)
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        // 1 2 3, target is 4
        // 1 + 3
        // 2 + 2
        // 3 + 1
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int i = 1; i <target+1; i++){
            for(int num : nums){
                if(i>=num)
                    dp[i] +=dp[i-num];
            }
        }
        return dp[target];
    }
}
