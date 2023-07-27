package weeklyContest;

//leetcode submit region begin(Prohibit modification and deletion)
class LargestElementInAnArrayAfterMergeOperations {
    /**
     * 枚举法
     * @param nums
     * @return
     */
    public long maxArrayValue(int[] nums) {
        long ans = 0;
        for(int i = nums.length-1;i>=0;i--){
            long num = nums[i];
            long sum = num;
            while(i>0 && nums[i-1]<=sum){
                sum+=nums[i-1];
                i--;
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
