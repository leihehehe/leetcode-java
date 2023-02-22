package dp;

/**
 * Leetcode 983
 */
public class MinimumCostForTickets {
    /**
     * TIME: O(n)
     * SPACE: O(n)
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int maxDay = days[n-1];
        int[] dp = new int[maxDay+1];
        int pos = 0;
        for (int i = 1; i < maxDay+1; i++) {
            if(days[pos]==i){
                pos++;
                int day1= i-1>=0?i-1:0;
                int day7= i-7>=0?i-7:0;
                int day30= i-30>=0?i-30:0;
                dp[i] = Math.min(Math.min(dp[day1]+costs[0],dp[day7]+costs[1]),dp[day30]+costs[2]);
            }else{
                dp[i]=dp[i-1];
            }
        }
        return dp[maxDay];
    }
}
