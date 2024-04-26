package graph;

import java.util.ArrayDeque;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Medium
 * Weekly Contest 345
 */
class MaxMovesSolution1 {
    int[][] memo;
    public int maxMoves(int[][] grid) {
        int res = 0;
        memo = new int[grid.length][grid[0].length];
        for(int[] m:memo) Arrays.fill(m, -1);
        for(int i = 0;i<grid.length;i++){
            res = Math.max(res,dfs(grid,i,0));
        }
        return res;
    }
    //maximum number of moves
    public int dfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        //走到最后一列走不了了
        if(j==n-1){
            return 0;
        }
        if(memo[i][j]!=-1)
            return memo[i][j];
        int res = 0;
        int val = grid[i][j];
        //往右走
        if(j<n-1 && grid[i][j+1]>val)
            res = Math.max(res, dfs(grid, i, j+1)+1);
        //往右上走
        if(i>0 && j<n-1 && grid[i-1][j+1]>val)
            res = Math.max(res, dfs(grid, i-1, j+1)+1);
        //往右下走
        if(i<m-1 && j<n-1 && grid[i+1][j+1]>val)
            res = Math.max(res, dfs(grid, i+1, j+1)+1);
        memo[i][j] = res;
        return res;
    }
}
class MaxMovesSolution2 {
    public int maxMoves(int[][] grid) {
        int res = 0;
        int[][] memo = new int[grid.length][grid[0].length];
        int m = grid.length;
        int n = grid[0].length;
        for(int j = n-1;j>=0;j--){
            for(int i = 0;i<m;i++){
                int val = grid[i][j];
                if(j<n-1 && grid[i][j+1]>val)
                    memo[i][j] = Math.max(memo[i][j], memo[i][j+1]+1);
                //往右上走
                if(i>0 && j<n-1 && grid[i-1][j+1]>val)
                    memo[i][j] = Math.max(memo[i][j], memo[i-1][j+1]+1);
                //往右下走
                if(i<m-1 && j<n-1 && grid[i+1][j+1]>val)
                    memo[i][j] = Math.max(memo[i][j], memo[i+1][j+1]+1);
            }
        }
        for(int i =0;i<m;i++){
            res = Math.max(memo[i][0], res);
        }
        return res;
    }

}
class MaxMovesSolution3 {
    public int maxMoves(int[][] grid) {
        //bfs
        ArrayDeque<Integer> queue= new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        //row->col
        int[] visited = new int[m];
        for(int i = 0;i<m;i++){
            queue.offer(i);
        }
        int j = 0;
        while(!queue.isEmpty()){
            int sz = queue.size();
            if(j==n-1){
                return n-1;
            }
            for(int i = 0;i<sz;i++){
                int curRow = queue.poll();
                int val = grid[curRow][j];
                for(int r: new int[]{curRow-1,curRow+1,curRow}){
                    if(r>=0 &&r<m && j+1<n && visited[r] != j+1 && grid[r][j+1]>val){
                        queue.offer(r);
                        visited[r] = j+1;
                    }
                }

            }
            if(!queue.isEmpty()){
                j++;
            }
        }
        return j;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
