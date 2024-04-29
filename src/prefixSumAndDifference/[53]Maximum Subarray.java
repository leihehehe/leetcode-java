package prefixSumAndDifference;

//leetcode submit region begin(Prohibit modification and deletion)
class MaxSubArraySolution {
    //[0,-2,-1,-4,0,-1,1,3,-2,2]
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n+1];
        int min = 0;
        //找到max和min，但是max必须大于min
        //那么就可以边遍历变算答案（和当前index之前的最小值进行比较）
        int ans = nums[0];
        for(int i = 0;i<n;i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
            ans = Math.max(prefixSum[i+1] - min,ans);
            min = Math.min(prefixSum[i+1],min);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
