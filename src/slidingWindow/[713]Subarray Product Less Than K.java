package slidingWindow;

/**
 * Leetcode 713
 */
//leetcode submit region begin(Prohibit modification and deletion)
class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, r = 0;
        int product=1;
        int count =0;
        while(r<nums.length){
            int toAdd = nums[r];
            r++;
            product *=toAdd;
            while(product>=k && l<r){
                int toRemove = nums[l];
                l++;
                product/=toRemove;
            }
            count+=r-l;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
