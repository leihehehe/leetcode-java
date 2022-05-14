package backtracking.middle;

import java.util.*;

public class GenerateParentheses {
    /***
     * Leetcode 22. Generate Parentheses
     * StringBuilder will be faster than String, but it will make more memory consumption.
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        dfs(parenthesis,n,0,0,new StringBuilder());
        return parenthesis;
    }

    public void dfs(List<String> parenthesis,int n,int left, int right , StringBuilder path){
        if(left<right){
            return;
        }
        if(left==n && right==n){
            parenthesis.add(path.toString());
        }

        if(right<n){
            //add right ) - push
            path.append(")");
            dfs(parenthesis,n,left,right+1,path);
            //pop
            path.deleteCharAt(path.length()-1);
        }

        if(left<n){
            //add left ( - push
            path.append("(");
            dfs(parenthesis,n,left+1,right,path);
            //pop
            path.deleteCharAt(path.length()-1);
        }

        return ;
    }

    /***
     * Method 2: use String, and do not need to manually pop
     */
    /*public List<String> generateParenthesis(int n) {
        List<String> parenthesis = new ArrayList<>();
        dfs(parenthesis,n,0,0,"");
        return parenthesis;
    }

    public void dfs(List<String> parenthesis,int n,int left, int right , String path){
        if(left<right){
            return;
        }
        if(left==n && right==n){
            parenthesis.add(path);
        }

        if(right<n){
            //add right ) - push
            dfs(parenthesis,n,left,right+1,path+")");
            //pop
        }

        if(left<n){
            //add left ( - push
            dfs(parenthesis,n,left+1,right,path+"(");
            //pop
        }

        return ;
    }*/

}
