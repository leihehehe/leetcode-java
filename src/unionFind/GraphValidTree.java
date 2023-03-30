package unionFind;

/**
 * Leetcode 261
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        //union find to connect nodes
        //if two nodes are not the same group -> connect
        //there is a cycle, tree is in valid
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            if(uf.connected(edge[0],edge[1])) return false;
            else{
                uf.union(edge[0],edge[1]);
            }
        }
        if(uf.getCount()!=1) return false;
        return true;
    }

    class UnionFind{
        private int[] parent;
        private int count;
        public UnionFind(int n){
            parent = new int[n];
            count = n;
            for(int i =0;i<n;i++){
                parent[i] = i;
            }
        }
        public void union(int node1, int node2){
            int root1 = find(node1);
            int root2 = find(node2);
            if(root1==root2) return;
            parent[root1] = root2;
            count--;
        }
        public int find(int node){
            if(parent[node]!=node){
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }
        public boolean connected(int node1, int node2){
            return find(node1)==find(node2);
        }
        public int getCount(){
            return count;
        }
    }
}
