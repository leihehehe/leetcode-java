package slidingWindow;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class MaximumBeautySolution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = 0;
        int res = 0;
        //[l,r)
        while(r<n){
            int in = nums[r];
            r++;
            //无重叠部分
            while(in-k>nums[l]+k){
                l++;
            }
            res = Math.max(r - l,res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
