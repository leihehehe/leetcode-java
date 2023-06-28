package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class OutOfBoundaryPaths {
    int MOD = 1000000007;
    static int[][][] cache = new int[51][51][51];
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= maxMove; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        return dfs(m-1,n-1,maxMove,startRow,startColumn);
    }

    public int dfs(int m, int n, int maxMove, int curRow, int curCol){
        if(curRow<0 || curRow>m || curCol<0 || curCol>n){
            return 1;
        }
        if(maxMove<=0 && curCol<=n && curCol>=0 && curRow>=0 && curRow<=m){
            return 0;
        }

        if(cache[curRow][curCol][maxMove]!=-1) return cache[curRow][curCol][maxMove];
        // right
        long right = dfs(m,n,maxMove-1,curRow,curCol+1)%MOD;
        // left
        long left = dfs(m,n,maxMove-1,curRow,curCol-1)%MOD;
        // up
        long up = dfs(m,n,maxMove-1,curRow-1,curCol)%MOD;
        // down
        long down = dfs(m,n,maxMove-1,curRow+1,curCol)%MOD;
        long res = (right+left+up+down)%MOD;
        cache[curRow][curCol][maxMove]= (int)res;
        return (int)res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
