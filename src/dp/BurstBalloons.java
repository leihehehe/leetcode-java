package dp;

/**
 * Leetcode 312
 */
public class BurstBalloons {
    /**
     * Method 1
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        //create a new array
        int[] newNums = new int[n+2];
        //add two virtual balloons to the first and last place
        newNums[0] = newNums[n+1]=1;
        //re-assign nums[0..n-1] to newNums[1..n]
        for(int i =1;i<=n;i++){
            newNums[i] = nums[i-1];
        }
        //dp[i][j] => the maximum coins you can collect by bursting newNums[i..j]
        //to get dp[1][n]
        int[][] dp = new int[n+2][n+2];
        //base case
        //k is the selection
        //dp[i][j] = dp[i][k-1]+dp[k+1][j] + newNums[i]*newNums[k]*newNums[j]
        for(int i = 1;i<=n;i++){
            for(int l = 1;l+i-1<=n;l++){
                int r = l + i -1;
                for(int k = l;k<=r;k++){
                    dp[l][r] = Math.max(dp[l][r],dp[l][k-1]+dp[k+1][r]+newNums[l-1]*newNums[k]*newNums[r+1]);
                }
            }
        }
        return dp[1][n];
    }

    int res = Integer.MIN_VALUE;

    /**
     * Method 2: backtrack -> timeout error
     * @param nums
     * @return
     */
    public int maxCoinsMethod2(int[] nums) {
        backtracking(nums,0);
        return res;
    }

    public void backtracking(int[] nums, int score){
        if(nums.length==0){
            res = Math.max(res,score);
            return;
        }
        for(int i = 0;i<nums.length;i++){
            int p1 = i-1>=0?nums[i-1]:1;
            int p2 = i+1<nums.length?nums[i+1]:1;
            int point = p1*nums[i]*p2;
            //create a new arr to store
            int[] newNums = new int[nums.length-1];
            for(int j=0;j<i;j++) newNums[j]=nums[j];
            for(int j = i+1;j<nums.length;j++) newNums[j-1]=nums[j];
            backtracking(newNums,score+point);
        }
    }
}
