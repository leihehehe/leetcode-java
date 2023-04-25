package backtracking.round2;

import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class CombinationSum {
    int sum = 0;
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates,target,0);
        return res;
    }
    public void backtrack(int[] candidates, int target,int start){
        if(target==sum){
            res.add(new LinkedList<>(path));
            return;
        }
        for(int i = start;i< candidates.length;i++){
            if(sum+candidates[i]>target) continue;
            sum+=candidates[i];
            path.addLast(candidates[i]);
            backtrack(candidates,target,i);
            sum-=candidates[i];
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
