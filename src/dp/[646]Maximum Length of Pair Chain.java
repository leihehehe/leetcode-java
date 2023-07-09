package dp;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a, b)->a[0]-b[0]);
        int n = pairs.length;
        int[] dp = new int[n];
        //最长递增子序列
        for(int i = 0;i<n;i++) dp[i] = 1;
        int maxLen = 1;
        for(int i = 1;i<n;i++){
            for(int j = 0;j<i;j++){
                if(pairs[j][1]<pairs[i][0])
                    dp[i] = Math.max(dp[j]+1,dp[i]);
            }
            maxLen = Math.max(dp[i],maxLen);
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
