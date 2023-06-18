package backtracking;

import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Permutations {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums,new LinkedList<>(),new boolean[nums.length]);
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> path, boolean[] used){
        //base case
        if(path.size()==nums.length){
            res.add(new LinkedList<>(path));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(used[i])
                continue;
            path.addLast(nums[i]);
            used[i]=true;
            backtrack(nums,path,used);
            path.removeLast();
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
