package dp;

import java.util.Arrays;

/**
 * Leetcode 435
 */
public class NonOverlappingIntervals {
    /**
     * Method 1: dynamic programming -> not suggested -> exceeds time limit
     * Time complexity: O(N^2)
     * Space complexity: O(N)
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->a[0]-b[0]);
        int n = intervals.length;
        int[] dp = new int[n];//the max number of non-overlapping intervals
        dp[0]=1;
        int maxNum = 1;
        for(int i =1;i<n;i++){
            dp[i]=1;
            for(int j =0;j<i;j++){
                if(intervals[i][0]>=intervals[j][1]) dp[i]=Math.max(dp[i],dp[j]+1);
            }
            maxNum = Math.max(dp[i],maxNum);
        }
        return n-maxNum;
    }

    /**
     * Method 2 (recommended): greedy algo
     * Time complexity: O(NlogN)
     * Space complexity: O(logN)
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervalsMethod2(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);//sort -> logN
        int n = intervals.length;
        //[[1,2],[1,3],[2,3],[3,4]]
        int end = intervals[0][1];
        int count = 0;
        for(int i =1;i<n;i++){
            //need remove one
            if(intervals[i][0]<end){
                //choose the smaller one
                end = Math.min(intervals[i][1],end);
                count++;
            } else end = intervals[i][1];
        }
        return count;
    }
}
