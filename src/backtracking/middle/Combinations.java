package backtracking.middle;

import java.util.ArrayList;
import java.util.List;

/***
 * LeetCode 77 - Combination
 * This is for the parent nodes with different numbers of child nodes
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        dfs(n,k,combinations,1,new ArrayList<>(),0);
        return combinations;
    }

    public void dfs(int n, int k,List<List<Integer>> combinations, int start, List<Integer> path,int layer){
        if(layer==k){
            combinations.add(new ArrayList<>(path));
            return;
        }
        for(int i =start; i<= n; i++){
            //push
            path.add(i);
            dfs(n,k,combinations,i+1,path,layer+1);
            //pop
            path.remove(path.size()-1);
        }
    }
}

