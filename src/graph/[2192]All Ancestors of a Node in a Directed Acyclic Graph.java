package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class GetAncestorsSolution1 {
    List<Integer>[] ans;
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
        }

        ans = new ArrayList[n];
        Arrays.setAll(ans, i -> new ArrayList<>());
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        for (int start = 0; start < n; start++) {
            dfs(start, start, vis, g); // 从 start 开始 DFS
        }
        return Arrays.asList(ans);
    }
    public void dfs(int i, int start, int[] visited, List<Integer>[] graph){
        visited[i] = start;
        List<Integer> neighbors = graph[i];
        for(int neighbor:neighbors){
            if(visited[neighbor]!=start){
                ans[neighbor].add(start);
                dfs(neighbor,start,visited,graph);
            }

        }
    }

}
class GetAncestorsSolution2 {
    List<Integer>[] res;
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, x -> new ArrayList<>());
        for(int[] edge:edges){
            int to =edge[0];
            int from = edge[1];
            graph[from].add(to);
        }
        visited = new int[n];
        Arrays.fill(visited,-1);
        res = new ArrayList[n];
        Arrays.setAll(res, x -> new ArrayList<>());
        for(int i =0;i<n;i++){
            dfs(i,graph,i);
        }
        for(List<Integer> r: res){
            Collections.sort(r);
        }

        return Arrays.asList(res);

    }
    int[] visited;
    public void dfs(int i, List<Integer>[] graph, int start){
        for(int neighbor:graph[i]){
            if(visited[neighbor]!=start){
                visited[neighbor] = start;
                res[start].add(neighbor);
                dfs(neighbor,graph,start);
            }
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
