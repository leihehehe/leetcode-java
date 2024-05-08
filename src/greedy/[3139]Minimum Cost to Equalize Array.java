package greedy;

//leetcode submit region begin(Prohibit modification and deletion)
class MinCostToEqualizeArraySolution {
    private final static int MOD = (int)1e9+7;
    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
        int n = nums.length;
        if (n == 1) return 0;
        int max = nums[0], diffMax = 0;
        long diffSum = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        for (int i = 0; i < n; i++) {
            nums[i] = max - nums[i];
            diffSum = diffSum + nums[i];
            diffMax = Math.max(diffMax, nums[i]);
        }
        if (n == 2 || 2 * cost1 < cost2) {
            return (int)((diffSum * cost1) % MOD);
        }
        long cost;
        long res = Long.MAX_VALUE;
        for (int i = diffMax; i <= 2 * diffMax; i++) {
            if (diffSum - i >= i) {
                cost = (diffSum / 2) * cost2;
                if (diffSum % 2 != 0) cost += cost1;
            } else {
                cost = (long)(i - (diffSum - i)) * cost1 + (diffSum - i) * cost2;
            }
            res = Math.min(res, cost);
            diffSum += n;
        }
        return (int)(res%MOD);
    }
}

//leetcode submit region end(Prohibit modification and deletion)
