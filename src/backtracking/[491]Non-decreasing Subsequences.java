package backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class NonDecreasingSubsequences {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums,0,new LinkedList<>());
        return res;
    }

    public void backtrack(int[] nums, int start, LinkedList<Integer> path){
        //base case
        if(path.size()>1)
            res.add(new LinkedList<>(path));
        //
        Set<Integer> used = new HashSet<>();
        for(int i =start;i<nums.length;i++){
            if(!path.isEmpty() && path.getLast()>nums[i])
                continue;
            if(used.contains(nums[i]))
                continue;
            used.add(nums[i]);
            path.addLast(nums[i]);
            backtrack(nums,i+1,path);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
