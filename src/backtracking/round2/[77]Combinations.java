package backtracking.round2;

import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Combinations {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        //start from `1` because 1<=n<=20
        backtrack(n,k,1,0);
        return res;
    }

    public void backtrack(int n, int k,int start, int depth){
        //when depth reaches to `k`, add the `path` into `res`
        if(depth==k){
            res.add(new LinkedList<>(path));
            return;
        }
        //the index `start` is to limit the branches selected to be always greater than the current node
        for(int i = start;i<=n;i++){
            path.addLast(i);
            //here the `start` should be `i+1`
            backtrack(n,k,i+1,depth+1);
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
