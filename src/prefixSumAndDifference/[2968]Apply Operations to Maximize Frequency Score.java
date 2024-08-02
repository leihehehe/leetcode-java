package prefixSumAndDifference;

import java.util.Arrays;

class MaxFrequencyScoreSolution1 {
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
        long pre = (long) nums[mid] * (mid-l) - (preSum[mid]-preSum[l]);
        long post =preSum[r+1]-preSum[mid+1] - (long) nums[mid] * (r-mid);
        return pre + post;
    }
}

/**
 * Binary Search + median greedy + prefix
 */
class MaxFrequencyScoreSolution2 {
    public int maxFrequencyScore(int[] nums, long k) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] preSum = new long[n+1];
        for(int i = 0 ;i<n;i++){
            preSum[i+1] = preSum[i] + nums[i];
        }
        int l = 0, r = n;
        while(l<r){
            int mid = (l+r+1)>>1;
            if(check(nums,preSum,mid,k)){
                l = mid;
            }else{
                r = mid-1;
            }
        }
        return l;
    }

    public boolean check(int[] nums, long[] preSum, int len, long k){
        for(int r = nums.length-1;r>=len-1;r--){
            //r - l +1 = len
            int l = r - len + 1;
            int mid = l+r>>1;
            //calculate distance between mid and any other elements
            long pre = (long) nums[mid] * (mid-l) - (preSum[mid]-preSum[l]);
            long post =preSum[r+1]-preSum[mid+1] - (long) nums[mid] * (r-mid);
            long count = pre + post;
            if(count<=k) return true;
        }
        return false;
    }

}
