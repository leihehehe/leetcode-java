package backtracking.round2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class PermutationsII {
    boolean[] used;
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }
    public void backtrack(int[] nums){
        if(nums.length==path.size()){
            res.add(new LinkedList<>(path));
            return;
        }
        for(int i = 0;i< nums.length;i++){
            if(used[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
            used[i]=true;
            path.addLast(nums[i]);
            backtrack(nums);
            path.removeLast();
            used[i]=false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
