package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        // Map<Integer,Integer> countMap =new HashMap<>();
        int[] countArr = new int[10001];
        for(int num:nums){
            max = Math.max(num,max);
            countArr[num]++;
        }
        int[] dp = new int[max+1];
        //dp[0]
        dp[1] = countArr[1]*1;
        for(int i = 2;i<=max;i++){
            dp[i] = Math.max(dp[i-2]+i*countArr[i], dp[i-1]);
        }
        return dp[max];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
