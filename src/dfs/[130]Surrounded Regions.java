package dfs;

//leetcode submit region begin(Prohibit modification and deletion)
class SurroundedRegions {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i=0;i<rows;i++){
            if(board[i][0]=='O'){
                //first element
                floodFill(board,i,0);
            }
            if(board[i][cols-1]=='O'){
                floodFill(board,i,cols-1);
            }
        }
        for(int j=0;j<cols;j++){
            if(board[0][j]=='O'){
                //first element
                floodFill(board,0,j);
            }
            if(board[rows-1][j]=='O'){
                floodFill(board,rows-1,j);
            }
        }

        for(int i = 0;i<rows;i++){
            for(int j =0;j<cols;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='-'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void floodFill(char[][] board, int i, int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length){
            return;
        }
        if(board[i][j]=='O'){
            board[i][j] = '-';
            floodFill(board,i+1,j);
            floodFill(board,i,j+1);
            floodFill(board,i-1,j);
            floodFill(board,i,j-1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
