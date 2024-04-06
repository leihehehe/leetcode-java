package backtracking;

import java.util.ArrayList;
import java.util.List;

/***
 * LeetCode 77 - Combination
 * This is for the parent nodes with different numbers of child nodes
 */
class CombineSolution1 {
    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k);
        return res;
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public void dfs(int index, int n, int k){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }

        if((k-path.size())>n-index+1){
            return;
        }
        for(int i = index;i<=n;i++){
            path.add(i);
            dfs(i+1,n,k);
            path.remove(path.size()-1);
        }
    }
}

class CombineSolution2 {
    public List<List<Integer>> combine(int n, int k) {
        dfs(n,n,k);
        return res;
    }
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public void dfs(int index, int n, int k){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        int need = k-path.size();
        if(index<need){
            return;
        }
        for(int i = index;i>=1;i--){
            path.add(i);
            dfs(i-1,n,k);
            path.remove(path.size()-1);
        }
    }
}