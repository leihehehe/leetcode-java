package dp;

/**
 * Leetcode 174
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        //dp[i][j]-> the minimum health needed for dungeon[i][j]->dungeon[m-1][n-1]
        int[][] dp = new int[n + 1][m + 1];
        for(int i =0;i<=m;i++){
            dp[i][n]=Integer.MAX_VALUE;
        }
        for(int i =0;i<=m;i++){
            dp[m][i]=Integer.MAX_VALUE;
        }
        //if the bottom right room is a positive number, minimum health is 1(just to ensure the knight is alive), otherwise the minimum health should be abs(dungeon[m-1][n-1])+1
        dp[m-1][n-1]=dungeon[m-1][n-1]>=0?1:-dungeon[m-1][n-1]+1;
        for(int i= m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1) continue;
                //the minimumm initial health we need
                int health = Math.min(dp[i][j+1],dp[i+1][j])-dungeon[i][j];
                dp[i][j]=health>0?health:1;
            }
        }
        return dp[0][0];
    }
}
