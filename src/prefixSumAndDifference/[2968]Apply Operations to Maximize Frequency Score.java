package prefixSumAndDifference;

import java.util.Arrays;

class MaxFrequencyScoreSolution {
    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        int n = nums.length;
        //[l,r)
        int l = 0;
        long[] preSum = new long[n+1];
        for(int i = 0 ;i<n;i++){
            preSum[i+1] = preSum[i] + nums[i];
        }
        int res = 0;
        for(int r = 0;r<n;r++){
            while(count(l,r,nums,preSum)>k){
                l++;
            }
            res = Math.max(r-l+1,res);
        }
        return res;
    }
    //不用函数的速度会更快一点，这里是为了代码的可读性
    public long count(int l, int r, int[] nums, long[] preSum){
        int mid = l+r>>1;
        //calculate distance between mid and any other elements
        long pre = nums[mid] * (mid-l) - (preSum[mid]-preSum[l]);
        long post =preSum[r+1]-preSum[mid+1] - nums[mid] * (r-mid);
        long count = pre + post;
        return count;
    }
}
