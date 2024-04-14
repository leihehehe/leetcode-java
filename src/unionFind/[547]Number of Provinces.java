package unionFind;

//leetcode submit region begin(Prohibit modification and deletion)
class FindCircleNum {
    class UnionFind{
        int count = 0;
        int[] parent;
        public UnionFind(int n){
            this.count = n;
            this.parent = new int[n];
            for(int i = 0;i<n;i++){
                parent[i] = i;
            }
        }
        public void union(int i, int j){
            int rootI = findRoot(i);
            int rootJ = findRoot(j);
            parent[rootI] = rootJ;
            count--;
        }
        public boolean connected(int i, int j){
            return findRoot(i)== findRoot(j);
        }
        public int findRoot(int i){
            if(parent[i] != i){
                //当前节点的根节点等于他父亲的根节点
                parent[i] = findRoot(parent[i]);
            }
            return parent[i];
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(isConnected[i][j]==1 && !uf.connected(i,j)){
                    uf.union(i,j);
                }
            }
        }

        return uf.count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
