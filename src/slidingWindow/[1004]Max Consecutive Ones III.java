package slidingWindow;

//leetcode submit region begin(Prohibit modification and deletion)
class MaxConsecutiveOnesIII {
    public int longestOnesMethod1(int[] nums, int k) {
        int l = 0, r = 0;
        int countZero = 0;
        int maxLen = 0;
        while(r<nums.length){
            int toAdd = nums[r];
            r++;
            if(toAdd==0){
                countZero++;
            }
            if(countZero<=k){
                maxLen = Math.max(r-l,maxLen);
            }
            if(countZero>k){
                int toRemove = nums[l];
                l++;
                if(toRemove==0){
                    countZero--;
                }
            }

        }
        return maxLen;
    }
    public int longestOnesMethod2(int[] nums, int k) {
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
