package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class CountCompleteComponentsSolution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, x->new ArrayList<>());
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        visited = new boolean[n];
        int res = 0;
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                edgeCount = 0;
                nodes = 0;
                dfs(i,graph);
                edgeCount/=2;
                res += (edgeCount==nodes*(nodes-1)/2)?1:0;
            }
        }
        return res;
    }
    boolean[] visited;
    int edgeCount = 0;
    int nodes = 0;
    public void dfs(int i, List<Integer>[] graph){
        visited[i] = true;
        nodes++;
        for(int neighbor: graph[i]){
            edgeCount++;
            if(!visited[neighbor]){
                dfs(neighbor,graph);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
