package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class ValidPathSolution1 {
    boolean[] visited;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        visited = new boolean[n];
        return dfs(graph,source,destination);
    }
    public boolean dfs(List<Integer>[] graph, int source, int destination){
        if(source==destination) return true;
        visited[source] = true;
        boolean res = false;
        for(int neighbor: graph[source]){
            if(!visited[neighbor])
                res|= dfs(graph,neighbor,destination);
        }
        return res;
    }
}
class ValidPathSolution2 {
    class UnionFind{
        private int[] parent;
        public UnionFind(int n){
            parent = new int[n];
            for(int i = 0;i<n;i++){
                parent[i] = i;
            }
        }
        public boolean isConnected(int i, int j){
            return getRoot(i) == getRoot(j);
        }
        public void union(int i, int j){
            int rootI = getRoot(i);
            int rootJ = getRoot(j);
            parent[rootI] = rootJ;
        }
        public int getRoot(int i){
            if(parent[i]!=i){
                parent[i] = getRoot(parent[i]);
            }
            return parent[i];
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge:edges){
            int u = edge[0], v = edge[1];
            if(!uf.isConnected(u, v)){
                uf.union(u, v);
            }
        }
        return uf.isConnected(source, destination);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
