package unionFind;

/**
 * Leetcode 323
 */
class NumberOfConnectedComponentsInAnUndirectedGraph {
    private int[] parent;
    private int count;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        count = n;
        for(int i =0;i<n;i++){
            parent[i]=i;
        }
        for(int[] edge:edges){
            union(edge[0],edge[1]);
        }
        return count;
    }

    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootQ==rootP) return;
        parent[rootP] = rootQ;
        count--;
    }
    public int find(int node){
        if(parent[node]!=node){
            parent[node]=find(parent[node]);
        }
        return parent[node];
    }
    public int count(){
        return count;
    }
}
