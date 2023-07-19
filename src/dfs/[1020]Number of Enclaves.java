package dfs;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                floodFill(grid, i, 0);
            }
            if (grid[i][n - 1] == 1) {
                floodFill(grid, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                floodFill(grid, 0, j);
            }
            if (grid[m - 1][j] == 1) {
                floodFill(grid, m - 1, j);
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;

    }

    public void floodFill(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = -1;
            floodFill(grid, i, j + 1);
            floodFill(grid, i + 1, j);
            floodFill(grid, i - 1, j);
            floodFill(grid, i, j - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
