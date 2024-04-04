package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class GetAncestors {
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

//leetcode submit region end(Prohibit modification and deletion)
