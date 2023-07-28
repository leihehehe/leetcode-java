package graph;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegree = new int[n];
        for(List<Integer> edge:edges){
            int to = edge.get(1);
            inDegree[to]++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(inDegree[i]==0){
                res.add(i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
