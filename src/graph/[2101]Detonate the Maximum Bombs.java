package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class MaximumDetonationSolution {
    public int maximumDetonation(int[][] bombs) {
        //dfs一个一个的引爆
        int n = bombs.length;
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, x->new ArrayList<>());
        for(int i = 0;i<n;i++){
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long range1 = bombs[i][2];
            for(int j =0;j<n;j++){
                if(i==j) continue;
                long x2 = bombs[j][0];
                long y2 = bombs[j][1];
                long distance = (x1-x2)*(x1-x2) +(y1-y2) * (y1-y2);
                if(distance<=range1*range1){
                    graph[i].add(j);
                }
            }
        }
        int res = 0;
        for(int i = 0;i<n;i++){
            res = Math.max(res,dfs(i,graph,new boolean[n]));
        }
        return res;
    }
    public int dfs(int node,List<Integer>[] graph, boolean[] visited){
        int count = 1;
        visited[node] = true;
        for(int neighbor: graph[node]){
            if(visited[neighbor]) continue;
            count += dfs(neighbor,graph,visited);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
