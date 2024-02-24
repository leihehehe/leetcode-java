package graph;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class AllPathsSourceTarget {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        dfs(graph,0,path);
        return res;
    }
    public void dfs(int[][] graph, int i, List<Integer> path){
        path.add(i);
        if(i==graph.length-1){
            res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        int[] neighbors = graph[i];
        for(int neighbor:neighbors){
            dfs(graph,neighbor,path);
        }
        path.remove(path.size()-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
