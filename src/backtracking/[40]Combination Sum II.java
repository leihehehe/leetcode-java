package backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class CombinationSumII {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates,target,0,new LinkedList<>());
        return res;
    }
    int sum = 0;
    public void backtrack(int[] candidates, int target, int start, LinkedList<Integer> path){
        if(sum==target){
            res.add(new LinkedList<>(path));
            return;
        }
        for(int i = start;i<candidates.length;i++){
            if(candidates[i]+sum>target)
                break;
            if(i>start && candidates[i]==candidates[i-1])
                continue;
            path.addLast(candidates[i]);
            sum+=candidates[i];
            backtrack(candidates,target,i+1,path);
            path.removeLast();
            sum-=candidates[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
