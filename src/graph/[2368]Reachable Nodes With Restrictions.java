package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * DFS + graph
 */
class ReachableNodesWithRestrictionsSolution1 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashSet<Integer> restrictedNodes = new HashSet<>();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0;i<restricted.length;i++){
            restrictedNodes.add(restricted[i]);
        }
        for(int[] edge:edges){
            int node1 = edge[0];
            int node2 = edge[1];
            if(!restrictedNodes.contains(node1) && !restrictedNodes.contains(node2)){
                graph.get(node1).add(node2);
                graph.get(node2).add(node1);
            }
        }
        boolean[] visited = new boolean[n];
        dfs(graph,1,visited,0);
        int res = 0;
        for(int i =0;i<visited.length;i++){
            if(visited[i]){
                res++;
            }
        }
        return res;

    }
    public void dfs(List<List<Integer>> graph, int len, boolean[] visited,int curNode){

        visited[curNode] = true;
        List<Integer> children = graph.get(curNode);
        for(int child:children){
            if(visited[child]){
                continue;
            }
            dfs(graph,len+1,visited,child);
        }
    }
}

/**
 * UnionFind
 */
class ReachableNodesWithRestrictionsSolution2{
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        HashSet<Integer> restrictedNodes = new HashSet<>();
        for(int i = 0;i<restricted.length;i++){
            restrictedNodes.add(restricted[i]);
        }
        UnionFind uf = new UnionFind(n);
        for(int[] edge:edges){
            int node1 = edge[0];
            int node2 = edge[1];
            if(!restrictedNodes.contains(node1) && !restrictedNodes.contains(node2)){
                uf.union(node1,node2);
            }
        }
        int res = 0;
        for(int i = 0;i<n;i++){
            res += uf.find(i)==0?1:0;
        }
        return res;
    }

    class UnionFind{
        private int count;
        private int[] parent;
        public UnionFind(int n){
            this.count = n;
            parent = new int[n];
            for(int i = 0;i<n;i++){
                parent[i] = i;
            }
        }
        public void union(int p, int q){
            int rootP = find(p);
            int rootQ = find(q);
            if(rootP == rootQ){
                return;
            }
            //为了能union到0上
            if(rootP<rootQ){
                parent[rootQ] = rootP;
            }else{
                parent[rootP] = rootQ;
            }

        }
        public int find(int p){
            if(parent[p]!=p){
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }
        public boolean isConnected(int p, int q){
            return find(p)==find(q);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
