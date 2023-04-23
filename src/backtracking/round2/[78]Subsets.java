package backtracking.round2;

import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Subsets {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return res;
    }
    public void backtrack(int[] nums, int start){
        res.add(new LinkedList<>(path));
        for(int i = start; i<nums.length;i++){
            path.addLast(nums[i]);
            backtrack(nums,i+1);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
