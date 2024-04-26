package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class MinScore {
    class Pair{
        int node;
        int distance;
        public Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    public int minScore(int n, int[][] roads) {
        //build graph
        List<Pair>[] graph = new ArrayList[n+1];
        Arrays.setAll(graph, x->new ArrayList<>());
        visited = new boolean[n+1];
        for(int[] road:roads){
            graph[road[0]].add(new Pair(road[1],road[2]));
            graph[road[1]].add(new Pair(road[0],road[2]));
        }
        dfs(1,graph);
        return min;
    }
    boolean[] visited;
    int min = Integer.MAX_VALUE;
    public void dfs(int i, List<Pair>[] graph){
        visited[i] = true;
        for(Pair neighbor: graph[i]){
            min = Math.min(min,neighbor.distance);
            if(!visited[neighbor.node]){
                dfs(neighbor.node, graph);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
