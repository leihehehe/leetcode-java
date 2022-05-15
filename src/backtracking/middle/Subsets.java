package backtracking.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * Leetcode 78 Subsets
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        dfs(nums, nums.length,0,new ArrayList<>(),subsets);
        return subsets;
    }

    /**
     * Do not need an if condition for cutting nodes.(all subsets need to be included)
     * @param nums
     * @param length
     * @param start
     * @param path
     * @param subsets
     */
    public void dfs(int[] nums, int length, int start,List<Integer> path,List<List<Integer>> subsets){
        subsets.add(new ArrayList<>(path));
        for(int i =start;i<length;i++){
            path.add(nums[i]);
            dfs(nums,length,i+1,path,subsets);
            path.remove(path.size()-1);
        }

    }
}
