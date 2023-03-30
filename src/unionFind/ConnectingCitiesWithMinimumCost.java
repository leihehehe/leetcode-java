package unionFind;

import java.util.Arrays;

/**
 * Leetcode 1135
 */
public class ConnectingCitiesWithMinimumCost {
    /**
     * Kruskal algo
     * Time complexity: O(NlogN) N-> the number of edges
     * @param n
     * @param connections
     * @return
     */
    public int minimumCost(int n, int[][] connections) {
        //greedy algo
        //O(NlogN)
        Arrays.sort(connections,(a, b)->a[2]-b[2]);
        UnionFind uf = new UnionFind(n+1);
        int res=0;
        for(int[] connection:connections){
            if(uf.connected(connection[0],connection[1])) continue;
            res+=connection[2];
            uf.union(connection[0],connection[1]);
        }
        return uf.getCount()==2?res:-1;
    }
    class UnionFind{
        private int[] parent;
        private int count;
        public UnionFind(int n){
            parent = new int[n];
            count = n;
            for(int i = 0;i<n;i++){
                parent[i]=i;
            }
        }
        public void union(int node1, int node2){
            int root1= find(node1);
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
