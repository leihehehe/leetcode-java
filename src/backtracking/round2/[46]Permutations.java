package backtracking.round2;

import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }
    List<List<Integer>> res = new LinkedList<>();
    //record the path
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public void backtrack(int[] nums){
        if(path.size() == nums.length){
            res.add(new LinkedList<>(path));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(used[i]) continue;
            used[i]= true;
            path.addLast(nums[i]);
            backtrack(nums);
            path.removeLast();
            used[i]=false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
