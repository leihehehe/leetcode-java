package unionFind;

//leetcode submit region begin(Prohibit modification and deletion)
class ValidPath {
    class UnionFind{
        int[] parent;
        public UnionFind(int n){
            this.parent = new int[n];
            for(int i = 0;i<n;i++){
                parent[i] = i;
            }
        }
        public void union(int i, int j){
            int rootI = find(i);
            int rootJ = find(j);
            parent[rootI] = rootJ;
        }
        public int find(int i){
            if(parent[i]!=i){
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
        public boolean isConnected(int i, int j){
            return find(i)==find(j);
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            if(!uf.isConnected(edge[0],edge[1])){
                uf.union(edge[0], edge[1]);
            }
        }
        return uf.isConnected(source, destination);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
