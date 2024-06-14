package dp;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class MaxScoreSolution1 {
    long[][] memo;
    public long maxScore(int[] nums, int x) {
        //dp
        int n = nums.length;
        memo = new long[n][2];
        for(int i = 0;i<n;i++){
            Arrays.fill(memo[i], Long.MIN_VALUE/2);
        }
        return dfs(nums,x,0,nums[0]%2);
    }
    //total score
    //parity: 0->even, 1->odd
    public long dfs(int[] nums, int x, int i, int parity){
        if(i==nums.length) return 0;
        if(memo[i][parity]!=Long.MIN_VALUE/2) return memo[i][parity];
        //chosen
        long chosen = dfs(nums, x, i+1, nums[i]%2) + nums[i];
        //奇偶性不同，则扣分
        if(nums[i]%2!=parity){
            chosen -= x;
        }
        //not chosen
        long notChosen = dfs(nums, x, i+1, parity);
        return memo[i][parity] = Math.max(chosen,notChosen);
    }
}

class MaxScoreSolution2 {
    public long maxScore(int[] nums, int x) {
        //dp
        int n = nums.length;
        long[][] memo = new long[n+1][2];
        for(int i = n-1;i>=0;i--){
            int curParity = nums[i] % 2;
            memo[i][curParity] = memo[i+1][curParity]+ nums[i];
            memo[i][curParity^1] = Math.max(memo[i+1][curParity]+ nums[i]-x,memo[i+1][curParity^1]);
        }
        return memo[0][nums[0]%2];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
