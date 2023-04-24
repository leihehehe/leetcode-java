package backtracking.round2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0);
        return res;
    }
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public void backtrack(int[] nums, int start){
        res.add(new LinkedList<>(path));
        for(int i = start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            path.addLast(nums[i]);
            backtrack(nums,i+1);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
