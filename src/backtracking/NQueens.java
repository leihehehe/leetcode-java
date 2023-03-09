package backtracking;

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
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<n;i++){
            sb.append('.');
        }
        for(int i =0;i<n;i++){
            board.add(sb.toString());
        }
        backtracking(board,0);
        return res;

    }
    public void backtracking(List<String> board,int row){
        int n = board.size();
        if(row==n){
            res.add(new ArrayList<>(board));
            return;
        }
        //column
        for(int col = 0;col<n;col++){
            if(!isValid(board,row,col)) continue;
            char[] arr = board.get(row).toCharArray();
            arr[col]='Q';
            board.set(row,String.valueOf(arr));
            backtracking(board,row+1);
            arr[col]='.';
            board.set(row,String.valueOf(arr));
        }
    }

    public boolean isValid(List<String> board, int row, int col){
        //same col above this row
        int n = board.size();
        for(int i=0;i<=row;i++){
            if(board.get(i).charAt(col)=='Q') return false;
        }
        //upper right
        for(int i = row-1,j=col+1; i>=0&&j<n;i--,j++){
            if(board.get(i).charAt(j)=='Q') return false;
        }
        //upper left
        for(int i = row-1, j =col-1;i>=0 && j>=0; i--,j--){
            if(board.get(i).charAt(j)=='Q') return false;
        }
        return true;
    }
}
