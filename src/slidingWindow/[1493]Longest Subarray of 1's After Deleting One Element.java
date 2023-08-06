package slidingWindow;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestSubarrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int l = 0, r = 0;
        int zeroCount = 0;
        //[l,r)
        int max = 0;
        while(r<nums.length){
            int toAdd = nums[r];
            r++;
            if(toAdd==0){
                zeroCount++;
            }
            while(zeroCount>1){
                int toRemove = nums[l];
                l++;
                if(toRemove==0){
                    zeroCount--;
                }
            }
            max = Math.max(max,r-l-1);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
