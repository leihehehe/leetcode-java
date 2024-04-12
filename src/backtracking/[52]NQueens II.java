package backtracking;

/**
 * Leetcode 52
 */
class TotalNQueensSolution1 {
    boolean[] cols, mainDiagonal,antiDiagonal;
    public int totalNQueens(int n) {
        cols = new boolean[n];
        mainDiagonal = new boolean[2*n-1];
        antiDiagonal = new boolean[2*n-1];
        dfs(0,n);
        return res;
    }
    int res = 0;
    public void dfs(int r, int n){
        if(r==n){
            res++;
            return;
        }
        //col
        for(int col = 0;col<n;col++){
            if(!cols[col] && !mainDiagonal[r+col] && !antiDiagonal[r-col+n-1]){
                cols[col] = true;
                mainDiagonal[r+col] = true;
                antiDiagonal[r-col+n-1] = true;
                dfs(r+1,n);
                cols[col] = false;
                mainDiagonal[r+col] = false;
                antiDiagonal[r-col+n-1] = false;
            }
        }
    }
}
class TotalNQueensSolution2 {
    int[] cols;
    public int totalNQueens(int n) {
        cols = new int[n];
        dfs(0,n);
        return res;
    }
    int res = 0;
    public void dfs(int r, int n){
        if(r==n){
            res++;
            return;
        }
        //col
        for(int col = 0;col<n;col++){
            if(check(r, col)){
                cols[r] = col;
                dfs(r+1,n);
            }
        }
    }

    public boolean check(int row, int col){
        //此处应该检查之前已经填写过的row
        for(int r = 0;r<row;r++){
            if(cols[r] == col || r-cols[r] == row-col || r+cols[r] == row+col ){
                return false;
            }
        }
        return true;
    }
}