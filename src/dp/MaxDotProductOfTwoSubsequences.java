package dp;

/**
 * Leetcode 1458
 */
public class MaxDotProductOfTwoSubsequences {
    /**
     * Time complexity: O(mn)
     * Space complexity: O(mn)
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m][n];
        //dp[i][j] -> end with nums1[i] and nums1[j]
        dp[0][0] = nums1[0]*nums2[0];
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                //only current product i*j
                int product = nums1[i]*nums2[j];
                dp[i][j] = product;
                //choose previous products + current product
                if(i>0 && j>0) dp[i][j]= Math.max(dp[i-1][j-1]+product,dp[i][j]);
                //we don't choose j
                if(j>0) dp[i][j]= Math.max(dp[i][j-1],dp[i][j]);
                //we don't choose i
                if(i>0) dp[i][j]= Math.max(dp[i-1][j],dp[i][j]);
                //we don't choose the current products but choose previous ones
                if(i>0 && j>0) dp[i][j]= Math.max(dp[i-1][j-1],dp[i][j]);
            }
        }
        return dp[m-1][n-1];
    }
}
