package dp;

/**
 * Leetcode 300
 */
public class LongestIncreasingSubsequence {
    /**
     * Method 1: dynamic programming
     * Time complexity: O(N^2)
     * Space complexity: O(N)
     * @param nums
     * @return
     */
    public int lengthOfLISMethod1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0]=1;
        for(int i = 1;i<n;i++){
            dp[i]=1;//initialization
            for(int j = 0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
    /**
     * Method 2: greedy alg & binary search
     * Time complexity: O(NlogN)
     * Space complexity: O(N)
     * @param nums
     * @return
     */
    public int lengthOfLISMethod2(int[] nums) {
        int n = nums.length;
        if(n<=1) return n;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int end = 0;
        for(int i = 1;i<n;i++){
            if(nums[i]>arr[end]){
                end++;
                arr[end] = nums[i];
            }else{
                int l = 0, r = end;
                while(l<r){
                    int mid = l+(r-l)/2;
                    if(nums[mid]>=nums[i]) r = mid;
                    else l = mid+1;
                }
                arr[l] = nums[i];
            }
        }
        return end+1;
    }
}
