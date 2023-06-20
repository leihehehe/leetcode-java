package slidingWindow;

//leetcode submit region begin(Prohibit modification and deletion)
class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        //[l,r)
        int l = 0 , r = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while(r<nums.length){
            int addIn = nums[r];
            r++;
            sum+=addIn;
            while(sum>=target && l>=0){
                res = Math.min(res,r-l);
                int removeOut = nums[l];
                l++;
                sum-=removeOut;
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
