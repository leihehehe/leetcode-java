package dp;

import java.util.Arrays;

/**
 * 状态机dp
 */
class MaximumTotalCostSolution1 {
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        memo = new long[n][2];
        for(long[] m : memo)
            Arrays.fill(m,-1);

        return dfs(nums,0,1);
    }
    long[][] memo;
    //复杂度是O(N)，因为状态是N个，单个状态复杂度是O(1),所以总的复杂度是O(N)
    public long dfs(int[] nums, int i, int isPlus){
        if(i==nums.length) return 0;
        if(memo[i][isPlus]!=-1) return memo[i][isPlus];
        //first element?
        long isFirst = dfs(nums,i+1,1);
        long notFirst = dfs(nums,i+1,isPlus^1);
        if(isPlus == 1){
            isFirst += nums[i];
            notFirst += nums[i];
        }else{
            isFirst -= nums[i];
            notFirst -= nums[i];
        }
        return memo[i][isPlus] = Math.max(isFirst,notFirst);
    }
}

class MaximumTotalCostSolution2 {
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long[][] memo = new long[n+1][2];
        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<=1;j++){
                long isFirst = memo[i+1][1];
                long notFirst = memo[i+1][j^1];
                if(j == 1){
                    isFirst += nums[i];
                    notFirst += nums[i];
                }else{
                    isFirst -= nums[i];
                    notFirst -= nums[i];
                }
                memo[i][j] = Math.max(isFirst,notFirst);
            }
        }
        return memo[0][1];
    }
}

class MaximumTotalCostSolution3 {
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long[][] memo = new long[n+1][2];
        for(int i = n-1;i>=0;i--){
            memo[i][0] = Math.max(memo[i+1][1]-nums[i],memo[i+1][1]-nums[i]);
            memo[i][1] = Math.max(memo[i+1][1]+nums[i],memo[i+1][0]+nums[i]);
        }
        return memo[0][1];
    }
}

class MaximumTotalCostSolution4 {
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long f0 = 0, f1 = 0;
        for(int i = n-1;i>=0;i--){
            long tempF0 = f0;
            f0 = Math.max(f1-nums[i],f1-nums[i]);
            f1 = Math.max(f1+nums[i],tempF0+nums[i]);
        }
        return f1;
    }
}