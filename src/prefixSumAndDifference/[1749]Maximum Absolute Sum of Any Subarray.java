package prefixSumAndDifference;

//leetcode submit region begin(Prohibit modification and deletion)
class MaxAbsoluteSumSolution1 {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        int max = 0, min = 0;
        int maxRes = 0, minRes = 0;
        for(int i = 0;i<n;i++){
            prefix[i+1] = prefix[i]+nums[i];
            maxRes = Math.max(maxRes, prefix[i+1] - min);
            min = Math.min(prefix[i+1], min);
            minRes = Math.min(minRes,prefix[i+1]-max);
            max = Math.max(prefix[i+1], max);
        }
        return Math.max(Math.abs(maxRes),Math.abs(minRes));
    }
}
class MaxAbsoluteSumSolution2 {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int[] minDp = new int[n+1];
        int[] maxDp = new int[n+1];
        int max = 0;
        int min = 0;
        for(int i = 1;i<=n;i++){
            maxDp[i] = Math.max(maxDp[i-1]+nums[i-1],nums[i-1]);
            minDp[i] = Math.min(minDp[i-1]+nums[i-1],nums[i-1]);
            max = Math.max(max,maxDp[i]);
            min = Math.min(min,minDp[i]);
        }
        return Math.max(Math.abs(max),Math.abs(min));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
