package dp;

class MaximumLengthISolution1 {
    public int maximumLength(int[] nums) {
        int k = 2;
        int[][] dp = new int[k][k];
        int max = 0;
        for(int x: nums){
            x = x%k;
            for(int y = 0;y<k;y++){
                dp[y][x] = dp[x][y] + 1;
                max = Math.max(max,dp[y][x]);
            }
        }
        return max;
    }
}
class MaximumLengthISolution2 {
    public int maximumLength(int[] nums) {
        int k = 2;
        int max = 0;
        for(int m = 0;m<k;m++){
            int[] dp = new int[k];
            for(int x:nums){
                x = x%k;
                int y = (m - x + k) %k;
                dp[x] = dp[y]+1;
                max = Math.max(dp[x],max);
            }
        }
        return max;
    }
}