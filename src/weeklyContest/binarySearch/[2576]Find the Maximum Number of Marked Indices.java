package weeklyContest.binarySearch;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Medium
 * 二分答案
 * O(NlogN)
 * Weekly Contest 334
 */
class MaxNumOfMarkedIndices {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        //如果每个数字都可以组成pairs，那么最多可以有n/2个pairs,因此我们直接二分查找答案
        int n = nums.length;
        int l = 0, r = n/2;
        while(l<r){
            int mid = l+(r-l+1)/2;
            if(check(nums, mid)){
                l = mid;
            }else{
                //不是mid个pairs
                r = mid-1;
            }
        }
        return l*2;
    }

    public boolean check(int[] nums, int mid){
        int n = nums.length;
        for(int i = 0; i < mid; i++){
            if(nums[i]*2>nums[n-mid+i]) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
