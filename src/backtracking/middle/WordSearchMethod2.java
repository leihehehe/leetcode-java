package backtracking.middle;

/**
 * Leetcode 79 - Word Search
 * Using directions array to iterate the tree
 */
public class WordSearchMethod2 {
    public static final int[][] directions=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        boolean[][] visited = new boolean[rows][columns];

        int curTarget = 0;
        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board[0].length; j++){
                if (dfs(board, word,curTarget, i, j,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][]board, String word,int cur,int i ,int j,boolean[][] visited){
        //this needs to be executed first, since when it is detected as a empty node, it should return false
        if(cur==word.length()){
            return true;
        }

        if(i<0 || j<0 || i>board.length-1 || j>board[0].length-1|| visited[i][j]){
            return false;
        }
        //only when the current character is matched, enter next dfs()
        if(board[i][j]==word.charAt(cur)){
            visited[i][j]=true;
            for(int[] direct: directions){
                if(dfs(board,word,cur+1,i+direct[0],j+direct[1],visited))
                    return true;
            }
            visited[i][j]=false;

        }
        return false;

    }
}
