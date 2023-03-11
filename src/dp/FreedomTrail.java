package dp;

import java.util.*;

/**
 * Leetcode 514
 * Time Complexity: O(mn^2)
 * Space Complexity: O(mn)
 */
public class FreedomTrail {
    Map<Character, List<Integer>> charToIndex = new HashMap<>();
    int[][] memo;
    public int findRotateSteps(String ring, String key) {
        int m = ring.length(), n = key.length();
        memo = new int[m][n];
        for(int i =0;i<ring.length();i++){
            char c = ring.charAt(i);
            charToIndex.putIfAbsent(c,new ArrayList<>());
            charToIndex.get(c).add(i);
        }
        return dp(ring,0,key,0);
    }
    //when ring[i] is aligned at the 12:00 direction, the minimum number of steps to spell key[j..end]
    public int dp(String ring, int i, String key, int j){
        //base case
        if(j==key.length()) return 0;
        if(memo[i][j]!=0) return memo[i][j];
        int res = Integer.MAX_VALUE, n = ring.length();
        for(int k :charToIndex.get(key.charAt(j))){
            //steps requied for moving from i to k
            int step = Math.abs(k-i);
            //compare with another move direction - clockwide/anticlockwise
            step = Math.min(step,n-step);
            //find the next key, rotate the ring to make ring[k] aligned at the 12:00 direction
            int subProblem = dp(ring,k,key,j+1);
            res = Math.min(res,1+step+subProblem);
        }
        memo[i][j]=res;
        return res;
    }

    public int findRotateStepsMethod2(String ring, String key) {
        int n = ring.length(), m = key.length();
        Map<Character, List<Integer>> charToIndex = new HashMap<>();
        //store all the indexes for ring
        for (int i = 0; i < n; ++i) {
            char c = ring.charAt(i);
            charToIndex.putIfAbsent(c, new ArrayList<>());
            charToIndex.get(c).add(i);
        }
        //dp[i][j]-> when ring[j] is at the 12:00 direction, minimum steps required to spell key[0..i]
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        //initialization
        for (int index : charToIndex.get(key.charAt(0))) {
            dp[0][index] = Math.min(index, n - index) + 1;
        }

        for (int i = 1; i < m; ++i) {
            //iterate all indexes for key[i], and these indexes will always be the index that was at 12:00 before a new rotation starts.
            for (int j : charToIndex.get(key.charAt(i))) {
                //get previous indexes that were at the 12:00 direction -> previous index in KEY
                for (int k : charToIndex.get(key.charAt(i - 1))) {
                    //dp[i][j]=min(dp[i][j],min(clockwise,anticlockwise)+1+dp[i-1][k previous at 12:00]))
                    //clockwise = rotate k(previous index at 12:00 direction) to j(current target index)
                    dp[i][j] = Math.min(dp[i][j], Math.min(Math.abs(j - k), n - Math.abs(j - k))+dp[i - 1][k] + 1 );
                }
            }
        }
        //get the minimum value
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }

}
