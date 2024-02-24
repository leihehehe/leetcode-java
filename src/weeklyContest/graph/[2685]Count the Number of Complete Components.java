package weeklyContest.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Medium
 * Weekly Contest 345
 */
class CountCompleteComponents {
    public int countCompleteComponents(int n, int[][] edges) {
        //建图
        List<Integer>[] graph = new ArrayList[n];
        visited = new boolean[n];
        Arrays.setAll(graph, e->new ArrayList<>());
        for(int[] edge:edges){
            int v1 = edge[0];
            int v2 = edge[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            v=0;
            e=0;
            dfs(graph, i);
            if(e==v*(v-1)){
                ans++;
            }

        }
        return ans;
    }
    int v,e;
    boolean[] visited;
    public void dfs(List<Integer>[] graph, int i){
        visited[i] = true;
        List<Integer> neighbors = graph[i];
        v++;
        e+=neighbors.size();
        for(int neighbor : neighbors){
            if(!visited[neighbor]){
                dfs(graph,neighbor);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
