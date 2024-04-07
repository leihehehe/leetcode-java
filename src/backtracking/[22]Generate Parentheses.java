package backtracking;

import java.util.*;

class GenerateParenthesesSolution1 {
    public List<String> generateParenthesis(int n) {
        dfs(0,n,0);
        return res;
    }
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    //第i个位置我们应该填写左括号还是右括号？
    public void dfs(int i, int n, int left){
        if(i==n*2){
            res.add(sb.toString());
            return;
        }
        if(left<n){
            sb.append('(');
            dfs(i+1,n,left+1);
            sb.deleteCharAt(sb.length()-1);
        }
        if(i-left<left){
            sb.append(')');
            dfs(i+1,n,left);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}