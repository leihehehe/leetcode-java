package dfs;

//leetcode submit region begin(Prohibit modification and deletion)
class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 ||j<0 ||i>=m || j>=n) return;
        if(grid[i][j]=='0') return;
        grid[i][j]='0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
