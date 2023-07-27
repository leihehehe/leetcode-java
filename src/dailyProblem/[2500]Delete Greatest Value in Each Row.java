package dailyProblem;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int deleteGreatestValue(int[][] grid) {
        //124
        //133
        //sorting
        int row = grid.length;
        for(int i =0;i<row;i++){
            Arrays.sort(grid[i]);
        }
        int col = grid[0].length;
        int curCol = grid[0].length-1;
        int sum = 0;
        for(int j = 0;j<col;j++){
            int greatest = grid[0][curCol];
            for(int i = 0;i<row;i++){
                greatest = Math.max(greatest,grid[i][curCol]);
            }
            sum+=greatest;
            curCol--;
        }

        return sum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
