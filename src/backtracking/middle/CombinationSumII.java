package backtracking.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    /***
     * Leetcode 40 Combination Sum II
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();
        dfs(candidates,target,candidates.length,0,0,0,new ArrayList<>(),combinations);
        return combinations;
    }
    public void dfs(int[] candidates, int target, int length, int layer, int start, int sum,List<Integer> path ,List<List<Integer>> combinations){
        if(sum==target) {
            combinations.add(new ArrayList<>(path));
            return;
        }

        if(layer==length){
            return;
        }

        for(int i=start;i<length;i++){
            //if current candidates is larger than target, do not continue this loop
            if((sum+candidates[i])>target){
                break;
            }
            //check the second node. i have to be larger than start, otherwise the next dfs() will be affected;
            if(i>start && candidates[i] == candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates,target,length,layer+1,i+1,sum+candidates[i],path,combinations);
            path.remove(path.size()-1);
        }


    }
}
