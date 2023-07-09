package dp;

import java.util.Arrays;

/**
 * Leetcode 354
 */
class RussianDollEnvelopes {
    /**
     * Method 1: greedy algo + binary search
     * Time complexity: O(nlogn)
     * Space complexity: O(n)
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes,(a, b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int[] height = new int[n];
        height[0]=envelopes[0][1];
        int end = 0;
        for(int i = 1;i<n;i++){
            int target  = envelopes[i][1];
            if(height[end]<target) height[++end]=target;
            else{
                int l = 0, r = end;
                while(l<r){
                    int mid = l+(r-l)/2;
                    if(height[mid]<target){
                        l= mid+1;
                    }else r= mid;
                }
                height[l] = target;
            }
        }
        return end+1;
    }

    /**
     * Method 2: dp
     * Time complexity: O(N^2)
     * Space complexity: O(N)
     * @param envelopes
     * @return
     */
    public int maxEnvelopesMethod2(int[][] envelopes) {
        int n =envelopes.length;
        //sort by width but if width is the same, sort by height.
        Arrays.sort(envelopes, (a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 1;
        for(int i =1;i<n;i++){
            dp[i]=1;
            for(int j = 0;j<i;j++){
                if(envelopes[j][0]<envelopes[i][0] && envelopes[j][1]<envelopes[i][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(dp[i],res);
        }
        return res;
    }
}
