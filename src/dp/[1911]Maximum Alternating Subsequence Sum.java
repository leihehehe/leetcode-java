package dp;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class MaxAlternatingSumSolution1 {
    long[][] memo;
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        memo = new long[n][2];
        for(int i = 0;i<n;i++) Arrays.fill(memo[i],Long.MIN_VALUE);
        return dfs(nums,n-1,1);
    }

    public long dfs(int[] nums, int i, int odd){
        if(i<0){
            return 0;
        }
        if(memo[i][odd]!=Long.MIN_VALUE) return memo[i][odd];
        if(odd==1){
            //长度为奇数
            //1,2,3,4,5
            //(1+3+5) - (2+4)
            return memo[i][odd] = Math.max(dfs(nums,i-1,1),dfs(nums, i-1, 0)+nums[i]);
        }
        //长度为偶数
        //1,2,3,4
        //(1+3)-(2+4)
        return memo[i][odd] = Math.max(dfs(nums,i-1,0),dfs(nums,i-1,1)-nums[i]);
    }
}
class MaxAlternatingSumSolution2 {

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] memo = new long[n+1][2];
        for(int i = 0;i<n;i++){
            memo[i+1][1] = Math.max(memo[i][1],memo[i][0]+nums[i]);
            memo[i+1][0] = Math.max(memo[i][0],memo[i][1]-nums[i]);
        }

        return memo[n][1];
    }
}
class MaxAlternatingSumSolution3 {

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] memo = new long[2];
        for(int i = 0;i<n;i++){
            memo[1] = Math.max(memo[1],memo[0]+nums[i]);
            memo[0] = Math.max(memo[0],memo[1]-nums[i]);
        }

        return memo[1];
    }
}
class MaxAlternatingSumSolution4 {

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long odd = 0;
        long even = 0;
        for(int i = 0;i<n;i++){
            long newOdd = Math.max(odd,even+nums[i]);
            long newEven = Math.max(even,odd-nums[i]);
            odd = newOdd;
            even = newEven;
        }

        return odd;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
