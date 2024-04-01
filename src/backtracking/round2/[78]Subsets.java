package backtracking.round2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class SubSetsSolution1 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return res;
    }
    List<Integer> path = new ArrayList<>();
    public void dfs(int i, int[] nums){
        if(i==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        //chosen;
        path.add(nums[i]);
        dfs(i+1,nums);
        path.remove(path.size()-1);
        //not chosen
        dfs(i+1,nums);
    }
}
class SubSetsSolution2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0);
        return res;
    }
    List<Integer> path = new ArrayList<>();
    public void dfs(int[] nums, int index){
        res.add(new ArrayList<>(path));

        for(int i = index;i<nums.length;i++){
            path.add(nums[i]);
            dfs(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
