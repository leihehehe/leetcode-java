package dfs;

import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n =grid[0].length;
        Set<String> pathSet = new HashSet<>();
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid,i,j,sb,66);
                    pathSet.add(sb.toString());
                }
            }
        }
        return pathSet.size();
    }
    public void dfs(int[][] grid, int i, int j,StringBuilder sb, int dir){
        int m = grid.length, n = grid[0].length;
        if(i<0 || j<0 ||i>=m || j>=n) return;
        if(grid[i][j]==0) return;
        grid[i][j]=0;
        sb.append(dir).append(",");
        dfs(grid,i-1,j,sb,1);//upward
        dfs(grid, i+1, j,sb,2);//down
        dfs(grid,i,j-1,sb,3);//left
        dfs(grid, i, j+1,sb,4);//right
        sb.append(-dir).append(",");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
