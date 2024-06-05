package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class MaxSubarraysSolution {
    public int maxSubarrays(int[] nums) {
        int andRes = -1;
        int n = nums.length;
        int count = 0;
        for(int i = 0;i<n;i++){
            andRes &= nums[i];
            if(andRes==0){
                count++;
                if(i+1<n) andRes = -1;
            }
        }
        return Math.max(count,1);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
