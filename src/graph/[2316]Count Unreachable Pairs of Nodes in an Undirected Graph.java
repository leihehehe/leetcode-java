package graph;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class CountPairsSolution1 {
    public long countPairs(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, x->new ArrayList<>());
        for(int[] edge:edges){
            int a = edge[0], b= edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        visited = new boolean[n];
        long res = 0;
        long totalSize = 0;
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                int size = dfs(i,graph);
                res += size * totalSize;
                totalSize+=size;
            }
        }
        return res;
    }
    boolean[] visited;
    public int dfs(int i, List<Integer>[] graph){
        //当前节点算一个
        visited[i] = true;
        int curSize = 1;
        for(int neighbor: graph[i]){
            if(!visited[neighbor]){
                curSize+=dfs(neighbor,graph);
            }
        }
        return curSize;
    }

}
class CountPairsSolution2 {
    class UnionFind{
        int count;
        int[] parent;
        int[] group;
        public UnionFind(int n){
            this.count = n;
            this.parent = new int[n];
            this.group = new int[n];
            Arrays.fill(group,1);
            for(int i = 0;i<n;i++){
                parent[i] = i;
            }
        }
        public void union(int i, int j){
            int rootI = find(i);
            int rootJ = find(j);
            parent[rootI] = rootJ;
            group[rootJ]+=group[rootI];
        }
        public int find(int i){
            if(parent[i]!=i){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
        public int getSize(int i){
            return group[i];
        }
        public boolean isConnected(int i, int j){
            return find(i) == find(j);
        }
    }
    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge:edges){
            int a = edge[0], b = edge[1];
            if(!uf.isConnected(a, b)){
                uf.union(a, b);
            }
        }
        long res = 0;
        int count = n;
        Set<Integer> records = new HashSet<>();
        for(int i = 0;i<n;i++){
            int root = uf.find(i);
            if(!records.contains(root)){
                count-=uf.getSize(root);
                res+=uf.getSize(root) * (long)count;
                records.add(root);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
