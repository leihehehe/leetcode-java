package weeklyContest;

class MaximumNumberOfJumpsToReachTheLastIndex {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];

        for(int j = 1;j<n;j++){
            if(nums[j]-nums[0]>= -target && nums[j]-nums[0]<=target){
                dp[j] = 1;
            }
        }
        for(int j =1;j<n;j++){
            for(int i = 0;i<j;i++){
                //-target <= nums[j] - nums[i] <= target
                if(nums[j]-nums[i]>= -target && nums[j]-nums[i]<=target && dp[i]!=0){
                    dp[j] = Math.max(dp[i]+1,dp[j]);
                }
            }
        }
        return dp[n-1]==0?-1:dp[n-1];
    }
}
