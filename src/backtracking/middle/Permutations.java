package backtracking.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 46
 * This method used dfs(depth-first search)
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> combinations=new ArrayList<>();
        if(nums.length==0){
            return combinations;
        }
        dfs(nums,nums.length,0,new boolean[nums.length],new ArrayList<>(),combinations);
        return combinations;
    }

    public void dfs(int[] nums,int length, int depth, boolean[] visited, List<Integer> path, List<List<Integer>> combinations){
        if(depth==length){
            //use arraylist to convert path to a arraylist
            combinations.add(new ArrayList<>(path));
            return;
        }
        for(int i =0; i<length; i++){
            if(!visited[i]){
                path.add(nums[i]);
                visited[i]=true;
                dfs(nums,length,depth+1,visited,path,combinations);
                path.remove(path.size()-1);
                visited[i]=false;
            }
        }
    }
}
