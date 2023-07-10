package design;

//leetcode submit region begin(Prohibit modification and deletion)
class GameOfLife {
    public void gameOfLife(int[][] board) {
        //live cell with <2 live neighbors = dies
        //live cell with >2~3 live neighbors = lives
        //live cell with >3 live neighbors = dies
        //dead cell with ==3 live neighbors = lives
        int m = board.length;
        int n = board[0].length;
        int[][] temp = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                temp[i][j] = board[i][j];
            }

        }
        int[][] direction = new int[][]{{1,1},{1,0},{0,1},{1,-1},{-1,-1},{0,-1},{-1,0},{-1,1}};
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                int count=0;
                if(temp[i][j]==1){
                    for(int[] dir: direction){
                        int newI = i+dir[0];
                        int newJ = j+dir[1];
                        if(newI<m && newI>=0 && newJ<n && newJ>=0 && temp[newI][newJ]==1){
                            count++;
                        }
                    }
                    if(count<2){
                        board[i][j] = 0;
                    }else if(count==2 || count==3){
                        board[i][j] = 1;
                    }else if(count>3){
                        board[i][j] = 0;
                    }

                }else{
                    for(int[] dir: direction){
                        int newI = i+dir[0];
                        int newJ = j+dir[1];
                        if(newI<m && newI>=0 && newJ<n && newJ>=0 && temp[newI][newJ]==1){
                            count++;
                        }
                    }
                    if(count==3){
                        board[i][j] = 1;
                    }
                }
            }
        }
    }

    /**
     * In place replacement
     * @param board
     */
    public void gameOfLifeInPlace(int[][] board) {
        //live cell with <2 live neighbors = dies
        //live cell with >2~3 live neighbors = lives
        //live cell with >3 live neighbors = dies
        //dead cell with ==3 live neighbors = lives
        int m = board.length;
        int n = board[0].length;
        int[][] direction = new int[][]{{1,1},{1,0},{0,1},{1,-1},{-1,-1},{0,-1},{-1,0},{-1,1}};
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                int count=0;
                //原本是活的
                if(board[i][j]==1 || board[i][j]==-1){
                    for(int[] dir: direction){
                        int newI = i+dir[0];
                        int newJ = j+dir[1];
                        if(newI<m && newI>=0 && newJ<n && newJ>=0 && (board[newI][newJ]==1 || board[newI][newJ]==-1)){
                            count++;
                        }
                    }
                    if(count<2){
                        //live -> dead
                        board[i][j] = -1;
                    }else if(count==2 || count==3){
                        board[i][j] = 1;
                    }else if(count>3){
                        //live -> dead
                        board[i][j] = -1;
                    }

                }else{
                    for(int[] dir: direction){
                        int newI = i+dir[0];
                        int newJ = j+dir[1];
                        if(newI<m && newI>=0 && newJ<n && newJ>=0 && (board[newI][newJ]==1 || board[newI][newJ]==-1)){
                            count++;
                        }
                    }
                    if(count==3){
                        //dead->live
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==-1){
                    board[i][j] = 0;
                }else if(board[i][j]==2){
                    board[i][j] = 1;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
