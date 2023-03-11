package dp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CheapestFlightsWithinKStops {
    int INF = 1000007;

    /**
     * Method 1
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //dp[i][j] => the cheapest price from i to dst by j steps
        int[][] dp = new int[n][k+2];
        for(int i =0;i<n;i++){
            Arrays.fill(dp[i],INF);
        }
        dp[dst][0]=0;
        for(int i=1;i<k+2;i++){
            for(int[] flight:flights){
                dp[flight[0]][i] = Math.min(dp[flight[0]][i],dp[flight[1]][i-1]+flight[2]);
            }
        }
        int ans = IntStream.of(dp[src]).min().getAsInt();
        return ans>=INF?-1:ans;

    }

    /**
     * Method 2
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPriceMethod2(int n, int[][] flights, int src, int dst, int k) {
        //dp[i][j]=>from src to i by j stops
        int INF = 1000007;
        int[][] dp = new int[n][k+2];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[src][0] = 0;

        for (int j = 1; j <= k+1; j++) {
            for (int[] flight : flights) {
                int from = flight[0], to = flight[1], price = flight[2];
                if (dp[from][j-1] != INF) {
                    dp[to][j] = Math.min(dp[to][j], dp[from][j-1] + price);
                }
            }
        }

        int ans = INF;
        for (int j = 1; j <= k+1; j++) {
            ans = Math.min(ans, dp[dst][j]);
        }
        return ans == INF ? -1 : ans;
    }
}
