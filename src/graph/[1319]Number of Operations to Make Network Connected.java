package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class MakeConnectedSolution1 {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        UnionFind uf = new UnionFind(n);
        for(int[] connection:connections){
            int a = connection[0], b = connection[1];
            if(!uf.isConnected(a, b)){
                uf.union(a, b);
            }
        }

        int cablesNeeded = uf.getNumOfGroups()-1;

        return cablesNeeded;
    }
    class UnionFind{
        private int[] parent;
        private int[] group;
        private int count;
        public UnionFind(int n){
            this.parent = new int[n];
            for(int i = 0;i<n;i++){
                parent[i] = i;
            }
            this.group = new int[n];
            Arrays.fill(group,1);
            this.count = n;
        }
        public void union(int i, int j){
            int rootI = find(i);
            int rootJ = find(j);
            parent[rootI] = rootJ;
            count--;
            group[rootJ]+=group[rootI];
        }
        public int find(int i){
            if(parent[i]!=i){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
        public boolean isConnected(int i, int j){
            return find(i) == find(j);
        }
        public int getNumOfGroups(){
            return count;
        }
        public int getSizeInGroup(int i){
            return group[i];
        }
    }
}
class MakeConnectedSolution2 {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, x->new ArrayList<>());
        for(int[] connection:connections){
            int a = connection[0];
            int b = connection[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        visited = new boolean[n];
        int groupCount = 0;
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                dfs(i,graph);
                groupCount++;
            }
        }
        return groupCount-1;
    }
    boolean[] visited;
    public void dfs(int i, List<Integer>[] graph){
        visited[i] = true;
        for(int neighbor: graph[i]){
            if(!visited[neighbor]){
                dfs(neighbor, graph);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
