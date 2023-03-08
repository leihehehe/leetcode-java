package backtracking.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 51
 */
public class NQueens {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        List<String> board = new ArrayList<>();
        for(int i = 0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j =0;j<n;j++){
                sb.append(".");
            }
            board.add(sb.toString());
        }
        backtrack(board,0);
        return res;

    }

    public void backtrack(List<String> board, int row){
        if(row==board.size()){
            res.add(new ArrayList<>(board));
            return;
        }
        int n = board.get(row).length();
        for(int i = 0;i<n;i++){
            if(!isValid(row,i,board)) continue;
            StringBuilder sb = new StringBuilder(board.get(row));
            sb.setCharAt(i,'Q');
            board.set(row,sb.toString());
            backtrack(board,row+1);
            sb.setCharAt(i,'.');
            board.set(row,sb.toString());
        }
    }
    public boolean isValid(int row, int col, List<String> board){
        int n = board.size();
        //same col
        for(int i =0;i<n;i++){
            if(board.get(i).charAt(col)=='Q') return false;
        }

        //top right
        for(int i =row-1,j=col+1;i>=0&&j<n;i--,j++){
            if(board.get(i).charAt(j)=='Q') return false;
        }

        //top left
        for(int i = row-1, j = col-1; i>=0&&j>=0;i--,j--){
            if(board.get(i).charAt(j)=='Q') return false;
        }
        return true;
    }
}
