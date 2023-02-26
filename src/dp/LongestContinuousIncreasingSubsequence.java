package dp;

/**
 * Leetcode 674
 */
public class LongestContinuousIncreasingSubsequence {
    /**
     * Method 1: dynamic programming
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0]=1;
        int res = 1;
        for(int i =1;i<n;i++){
            if(nums[i-1]<nums[i])
                dp[i]=dp[i-1]+1;
            else dp[i] = 1;
            res = Math.max(dp[i],res);
        }
        return res;
    }

    /**
     * Method 2: optimized dp
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param nums
     * @return
     */
    public int findLengthOfLCISMethod2(int[] nums) {
        int n = nums.length;
        int len = 1;
        int res = Integer.MIN_VALUE;
        for(int i =1;i<n;i++){
            if(nums[i-1]<nums[i])
                len = len+1;
            else len = 1;
            res = Math.max(len,res);
        }
        return res;
    }

    /**
     * Method 3: double pointers
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param nums
     * @return
     */
    public int findLengthOfLCISMethod3(int[] nums) {
        int n = nums.length;
        //[j,i) -> increasing
        int j = 0;
        int res = 1;
        int curLen =1;
        for(int i =1;i<n;i++){
            if(nums[i]>nums[i-1]) {
                curLen++;
                res=Math.max(res,curLen);
            }else {
                curLen=1;
                j = i;
            }
        }
        return res;
    }
}
