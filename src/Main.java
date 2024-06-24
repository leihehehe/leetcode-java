import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.minimumSum(new int[][]{{1,0,1},{1,1,1}});
    }

}
class Solution1 {
    public int minimumSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxVal = Integer.MAX_VALUE;

        // 构建前缀和数组
        int[][] prefixSum = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefixSum[i][j] = grid[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }

        // 初始化dp数组
        int[][][] dp = new int[rows + 1][cols + 1][4];
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                for (int k = 0; k < 4; k++) {
                    dp[i][j][k] = maxVal/2;
                }
            }
        }
        dp[0][0][0] = 0;

        // 计算dp数组
        for (int k = 1; k <= 3; k++) {
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    for (int x = 0; x < i; x++) {
                        if (prefixSum[i][j] - prefixSum[x][j] > 0) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[x][j][k - 1] + (i - x) * j);
                        }
                    }
                    for (int y = 0; y < j; y++) {
                        if (prefixSum[i][j] - prefixSum[i][y] > 0) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i][y][k - 1] + i * (j - y));
                        }
                    }
                }
            }
        }

        return dp[rows][cols][3] == maxVal ? -1 : dp[rows][cols][3];
    }
}