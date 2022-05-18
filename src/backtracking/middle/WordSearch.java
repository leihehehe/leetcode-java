package backtracking.middle;

public class WordSearch {

    /***
     * LeetCode 79. Word Search
     * used dfs and backtracking algorithm
     * @param board
     * @param word
     * @return
     */
    public  boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        boolean[][] visited = new boolean[rows][columns];

        int curTarget = 0;
        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board[0].length; j++){
                if (dfs(curTarget, board,word, i, j,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int cur,char[][] board, String word,int i, int j,boolean[][] visited){
        if(cur==word.length()){
            return true;
        }
        if(i<0 || j<0 || i>board.length-1 || j>board[0].length-1){
            return false;
        }
        if(visited[i][j]){
            return false;
        }
        if(board[i][j]!=word.charAt(cur)){
            return false;
        }
        visited[i][j]=true;
        //four directions
        boolean res = dfs(cur+1,board,word,i+1,j,visited)||
                dfs(cur+1,board,word,i,j+1,visited)||
                dfs(cur+1,board,word,i-1,j,visited)||
                dfs(cur+1,board,word,i,j-1,visited);
        visited[i][j]=false;
        return res;

    }


}
