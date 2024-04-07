package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1,k,n);
        return res;
    }

    //1-9
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public void dfs(int i, int k, int target){
        //超过了k个
        if(path.size()>k)
            return;
        //和大于n
        if(target<0) return;
        if(path.size()==k && target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        int need = k - path.size();
        //剩下的数不够
        if(need>10-i){
            return;
        }
        //chosen
        path.add(i);
        dfs(i+1,k,target-i);
        path.remove(path.size()-1);
        //not chosen
        dfs(i+1,k,target);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
