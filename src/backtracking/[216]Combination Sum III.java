package backtracking;

import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class CombinationSumIII {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k,n,1);
        return res;
    }
    public void backtrack(int k, int n, int start){
        if(path.size()==k && sum==n){
            res.add(new LinkedList<>(path));
            return;
        }
        for(int i= start;i<=9;i++){
            if(sum+i>n)
                break;
            sum+=i;
            path.addLast(i);
            backtrack(k,n,i+1);
            sum-=i;
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
