package dp;

import java.util.Arrays;

/**
 * Leetcode 416
 */
class PartitionEqualSubsetSum {
    /**
     * Method 1: dp
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i =0;i<nums.length;i++) sum+= nums[i];
        if(sum%2!=0) return false;
        sum/=2;//bag capacity
        boolean[][] dp = new boolean[nums.length][sum+1];
        //dp[i][j]=> nums[0..i] can be filled in the bag with the capacity of `sum`?
        for(int i = 0;i<nums.length;i++){
            dp[i][0] = true;
        }
        for(int i =1;i<nums.length;i++){
            for(int j = 1;j<sum+1;j++){
                //you don't have enough space to put this number into the bag
                if(j-nums[i-1]<0)
                    dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
            }
        }
        return dp[nums.length-1][sum];
    }

    /**
     * Method 2: optimized dp
     * @param nums
     * @return
     */
    public boolean canPartitionMethod2(int[] nums) {
        int sum = 0;
        for(int i =0;i<nums.length;i++) sum+= nums[i];
        if(sum%2!=0) return false;
        sum/=2;//bag capacity
        // boolean[][] dp = new boolean[nums.length][sum+1];
        // replace the two-dimensional array with one-dimensinal array
        boolean dp[] = new boolean[sum+1];
        //dp[i][j]=> nums[0..i] can be filled in the bag with the capacity of `sum`?
        dp[0] = true;
        for(int i =1;i<nums.length;i++){
            for(int j = sum;j>=0;j--){
                //you don't have enough space to put this number into the bag
                if(j-nums[i-1]>=0)
                    dp[j] = dp[j-nums[i-1]] || dp[j];
            }
        }
        return dp[sum];
    }

    /**
     * Method 3: dfs - timeout error
     * @param nums
     * @return
     */
    public boolean canPartitionMethod3(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;

        Arrays.sort(nums);
        reverse(nums);

        return partition(nums, sum, 0, 0);
    }
    public void reverse(int[] data) {
        for (int left = 0, right = data.length - 1; left < right; left++, right--) {
            int temp = data[left];
            data[left] = data[right];
            data[right] = temp;
        }
    }

    private boolean partition(int[] nums, int sum, int index,int p) {
        if(p == sum) return true;
        if(nums.length==index || p>sum) return false;
        if (partition(nums, sum, index + 1, p + nums[index])) {
            return true;
        }
        if (partition(nums, sum, index + 1, p)) {
            return true;
        }
        return false;
    }
}
