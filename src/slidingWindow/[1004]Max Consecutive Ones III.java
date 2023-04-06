package slidingWindow;

//leetcode submit region begin(Prohibit modification and deletion)
class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int l =0, r = 0;
        int count = 0;
        int res = 0;
        while(r<nums.length){
            int toAdd = nums[r];
            r++;
            if(toAdd==0) count++;
            while(count>k){
                int toRemove = nums[l];
                l++;
                if(toRemove==0) count--;
            }
            res = Math.max(res,r-l);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
