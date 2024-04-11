package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 51
 */
class Solution {
    public List<List<String>> solveNQueens(int n) {
        cols = new int[n];
        dfs(0,n);
        return res;
    }
    int[] cols;
    List<List<String>> res = new ArrayList<>();
    public void dfs(int r, int n){
        if(r==n){
            List<String> curAns = new ArrayList<>();
            for(int i = 0;i<n;i++){
                char[] row = new char[n];
                int col = cols[i];
                Arrays.fill(row,'.');
                row[col] = 'Q';
                curAns.add(new String(row));
            }
            res.add(curAns);
            return;
        }
        for(int col = 0;col<n;col++){
            if(check(r,col)){
                cols[r] = col;
                dfs(r+1,n);
            }
        }

    }
    public boolean check(int row, int col){
        for(int i = 0;i<row;i++){
            //确保这一列都没有相同的col
            if(col == cols[i] || (col-row)==(cols[i]-i) || (row+col)==(cols[i]+i) ){
                return false;
            }
        }
        return true;
    }
}
