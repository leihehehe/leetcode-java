package unionFind;

//leetcode submit region begin(Prohibit modification and deletion)
class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dummy = m * n;
        UnionFind uf = new UnionFind(m * n + 1);
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && grid[i][j] == 1) {
                    uf.union(i * n + j, dummy);
                } else {
                    if (grid[i][j] == 1) {
                        for (int[] direction : directions) {
                            int x = direction[0] + i;
                            int y = direction[1] + j;
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                                uf.union(x * n + y, i * n + j);
                            }
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !uf.isConnected(dummy,i*n+j)){
                    res++;
                }
            }
        }
        return res;
    }

    class UnionFind {
        private int count;
        private int[] parent;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootQ] = rootP;
            count--;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int getCount() {
            return count;
        }

        public boolean isConnected(int p, int q){
            return find(p)==find(q);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
