package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class MaximumOrSolution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        long[] pre = new long[n];
        long[] suffix = new long[n];
        pre[0] = 0;
        for(int i = 1;i<n;i++){
            pre[i] = pre[i-1] | nums[i-1];
        }
        suffix[n-1] = 0;
        for(int i = n-2;i>=0;i--){
            suffix[i] = suffix[i+1] | nums[i+1];
        }
        long res = 0;
        for(int i = 0;i<n;i++){
            //这里要在nums[i]前面写long，因为long的二进制位数更多
            res = Math.max(pre[i]|((long)nums[i]<<k)|suffix[i],res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
