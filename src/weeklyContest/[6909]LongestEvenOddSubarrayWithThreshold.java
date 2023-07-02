package weeklyContest;

class LongestEvenOddSubarrayWithThreshold {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        //数字第一位必须是偶数
        //nums[l] % 2 == 0
        //对于范围 [l, r - 1] 内的所有下标 i ，nums[i] % 2 != nums[i + 1] % 2
        //对于范围 [l, r] 内的所有下标 i ，nums[i] <= threshold
        //以nums[i]结尾，满足题目要求的最长子数组的长度
        int n = nums.length;
        int[] dp = new int[n];
        for(int i =0;i<n;i++) dp[i] = nums[i]%2==0 && nums[i]<=threshold?1:0;
        for(int i =1;i<n;i++){
            if(nums[i]<=threshold && nums[i]%2!=nums[i-1]%2 && nums[i-1]<=threshold){
                dp[i] = Math.max(dp[i-1] + 1,dp[i]);
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0;i<dp.length;i++){
            res = Math.max(dp[i],res);
        }
        return res;
    }
}
