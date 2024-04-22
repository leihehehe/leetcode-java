package weeklyContest.dp;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class MinimumOperationsSolution1 {
    int[][] count;
    int[][] memo;
    public int minimumOperations(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        count = new int[n][10];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                count[j][grid[i][j]]++;
            }
        }
        memo = new int[n][11];
        for(int[] arr: memo)
            Arrays.fill(arr, -1);
        return m*n-dfs(grid,0,10);
    }

    //求的是第i列最多需要保留多少元素
    public int dfs(int[][] grid, int i, int pre){
        if(i==grid[0].length){
            return 0;
        }
        if(memo[i][pre]!=-1) return memo[i][pre];
        //枚举这一列要选的数
        int res = 0;
        for(int num = 0;num<=9;num++){
            //相邻的列不能相同，所以看上一列选的是什么
            if(pre==num) continue;
            //选num，代表这一列我要保留着一列之前就为num的元素
            res = Math.max(dfs(grid,i+1,num)+count[i][num],res);
        }
        memo[i][pre] = res;
        return res;
    }
}
class MinimumOperationsSolution2 {
    public int minimumOperations(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] count = new int[n][10];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count[j][grid[i][j]]++;
            }
        }
        int[][] memo = new int[n + 1][10];

        // Initialize for the last column's next (non-existent) state to 0
        for (int num = 0; num <= 9; num++) {
            memo[n][num] = 0;
        }

        // Iterate from the last column to the first column
        for (int j = n - 1; j >= 0; j--) {
            for (int pre = 0; pre <= 9; pre++) {
                for (int num = 0; num <= 9; num++) {
                    if (pre != num) { // Allow the first column to pick any num or ensure different from previous column
                        memo[j][num] = Math.max(memo[j][num], memo[j + 1][pre] + count[j][num]);
                    }
                }
            }
        }

        // Find the max value in the first column, allowing any initial number
        int maxVal = 0;
        for (int num = 0; num <= 9; num++) {
            maxVal = Math.max(maxVal, memo[0][num]);
        }

        return m * n - maxVal; // Minimum operations needed
    }
}
//leetcode submit region end(Prohibit modification and deletion)
