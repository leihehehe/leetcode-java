package backtracking.middle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/***
 * Leetcode 39
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        dfs(combinations,candidates,candidates.length,target,new ArrayList<>(),0,0);
        return combinations;
    }

    public void dfs(List<List<Integer>> combinations, int[] candidates, int length, int target, List<Integer> path, int sum, int start){
        //if the sum equal to the target number, add the path into combinations list
        if(sum==target){
            combinations.add(new ArrayList<>(path));
            return;
        }
        //if it is at the last layer, stop recursion
        if(sum > target){
            return;
        }
        for(int i=start; i<length;i++){
            //add the number to a temporary path
            path.add(candidates[i]);
            dfs(combinations,candidates,length,target,path,sum + candidates[i],i);
            path.remove(path.size()-1);
        }
    }
}
