package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * LeetCode 47
 */
class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations=new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums,nums.length,permutations,new ArrayList<>(),0,visited);
        return permutations;
    }
    public void dfs(int[] nums, int length,List<List<Integer>> permutations,List<Integer> path, int layer,boolean[] visited){
        if(layer==length){
            permutations.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<length;i++){
            if(visited[i]){
                continue;
            }
            //!visited[i-1] means the previous node should have been undone. So that we will not skip the cases like [1,1',2]
            //这个是为了检测同一层的前一个节点，而不是父亲节点。如果是同一层的节点，他的visited会为false，因为为了回溯，for循环中会在最后设置为false
            if(i>0 && nums[i]==nums[i-1] &&!visited[i-1]){
                continue;
            }
            path.add(nums[i]);
            visited[i]=true;
            dfs(nums,length,permutations,path,layer+1,visited);
            visited[i]=false;
            path.remove(path.size()-1);
        }
    }
}
