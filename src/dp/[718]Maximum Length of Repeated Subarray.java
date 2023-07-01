package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class MaximumLengthOfRepeatedSubarray {
    /**
     * DP
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m][n];
        int maxLen = Integer.MIN_VALUE;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(nums1[i]==nums2[j]){
                    if(i>0 && j>0)
                        dp[i][j] = dp[i-1][j-1]+1;
                    else
                        dp[i][j]=1;
                }else{
                    dp[i][j] = 0;
                }
                maxLen = Math.max(dp[i][j],maxLen);
            }
        }

        return maxLen;
    }
    /**
     * Optimized dp
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLengthOptimizedDP(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] dp = new int[n];
        int maxLen = Integer.MIN_VALUE;
        for(int i = 0;i<m;i++){
            for(int j = n-1;j>=0;j--){
                if(nums1[i]==nums2[j]){
                    if(i>0 && j>0)
                        dp[j] = dp[j-1]+1;
                    else
                        dp[j]=1;
                }else{
                    dp[j] = 0;
                }
                maxLen = Math.max(dp[j],maxLen);
            }
        }

        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
