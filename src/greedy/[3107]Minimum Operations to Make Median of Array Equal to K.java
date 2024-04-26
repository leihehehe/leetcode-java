package greedy;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class MinOperationsToMakeMedianK {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        //2,5,5,6,8
        int n = nums.length;
        int mid = n/2;
        long res = 0;
        for(int i = 0;i<n;i++){
            if(i<mid && nums[i]>k){
                res+=nums[i]-k;
            }
            if(i==mid){
                res+=Math.abs(nums[i]-k);
            }
            if(i>mid && nums[i]<k){
                res+=k-nums[i];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
