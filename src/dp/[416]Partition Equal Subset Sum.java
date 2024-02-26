package dp;

import java.util.Arrays;

/**
 * Leetcode 416
 */
class CanPartitionSolution1 {
    private Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num:nums) sum+=num;
        if(sum%2!=0) return false;
        int target = sum/2;

        memo = new Boolean[n][target+1];

        return dfs(nums, n-1, target);
    }

    public boolean dfs(int[] nums, int i, int target){
        if(i<0){
            if(target==0){
                return true;
            }
            return false;
        }
        if(memo[i][target]!=null){
            return memo[i][target];
        }
        boolean notChosen = dfs(nums,i-1,target);
        if(target<nums[i]){
            memo[i][target] = notChosen;
            return notChosen;
        }
        memo[i][target] = notChosen || dfs(nums,i-1,target-nums[i]);

        return memo[i][target];
        //choose or not choose

    }
}
class CanPartitionSolution2 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num:nums) sum+=num;
        if(sum%2!=0) return false;
        int target = sum/2;

        boolean[][] memo = new boolean[n+1][target+1];
        memo[0][0] = true;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<=target;j++){
                boolean notChosen = memo[i][j];
                if(j<nums[i]){
                    memo[i+1][j] = notChosen;
                }else{
                    memo[i+1][j] = notChosen || memo[i][j-nums[i]];
                }
            }
        }
        return memo[n][target];
    }
}
class CanPartitionSolution3 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num:nums) sum+=num;
        if(sum%2!=0) return false;
        int target = sum/2;
        boolean[] memo = new boolean[target+1];
        memo[0] = true;
        for(int i = 0;i<n;i++){
            for(int j = target;j>=0;j--){
                if(j>=nums[i]){
                    memo[j] = memo[j] || memo[j-nums[i]];
                }
            }
        }
        return memo[target];
    }
}