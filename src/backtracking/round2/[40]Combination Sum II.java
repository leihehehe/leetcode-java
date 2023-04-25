package backtracking.round2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates,target,0);
        return res;
    }
    int sum = 0;
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public void backtrack(int[] candidates, int target, int start){
        if(sum==target){
            res.add(new LinkedList<>(path));
            return;
        }
        for(int i = start;i<candidates.length;i++){
            if(sum+candidates[i]>target) continue;;
            if(i>start && candidates[i]==candidates[i-1]) continue;
            sum+=candidates[i];
            path.addLast(candidates[i]);
            backtrack(candidates,target,i+1);
            path.removeLast();
            sum-=candidates[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
