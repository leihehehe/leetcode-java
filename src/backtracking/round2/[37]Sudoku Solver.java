package backtracking.round2;

//leetcode submit region begin(Prohibit modification and deletion)
class SudokuSolver {
    public void solveSudoku(char[][] board) {
        backtrack(board,0,0);
    }
    public boolean backtrack(char[][] board, int i, int j){
        if(j==9) return backtrack(board,i+1,0);
        if(i==9) return true;
        if(board[i][j]!='.') return backtrack(board,i,j+1);
        for(char c = '1';c<='9';c++){
            if(!isValid(board,i,j,c)) continue;
            board[i][j]=c;
            if(backtrack(board,i,j+1)) return true;
            board[i][j]='.';
        }
        return false;
    }

    public boolean isValid(char[][] board, int i, int j, char target){
        for(int row = 0;row<board.length;row++){
            if(board[row][j]==target) return false;
        }
        for(int col = 0;col<board[0].length;col++){
            if(board[i][col]==target) return false;
        }
        int startRow = (i/3)*3;
        int startCol = (j/3)*3;
        for(int row = startRow;row< startRow+3;row++){
            for(int col = startCol;col<startCol+3;col++){
                if(board[row][col]==target) return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
