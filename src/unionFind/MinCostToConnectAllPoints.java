package unionFind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Leetcode 1584
 */
public class MinCostToConnectAllPoints {
    /**
     * Kruskal algo
     * @param points
     * @return
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> pairs = new ArrayList<>();
        for(int i =0;i<n;i++){
            for(int j = i+1;j<n;j++){
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0],yj = points[j][1];
                pairs.add(new int[]{
                        i,j,Math.abs(xi-xj)+Math.abs(yi-yj)
                });
            }
        }
        Collections.sort(pairs,(a, b)->a[2]-b[2]);
        UnionFind uf = new UnionFind(n);
        int min = 0;
        for(int[] pair:pairs){
            if(uf.conneceted(pair[0],pair[1])) continue;
            min+=pair[2];
            uf.union(pair[0],pair[1]);
        }
        return uf.count==1?min:0;
    }
    class UnionFind{
        private int[] parent;
        private int count;
        public UnionFind(int n){
            parent = new int[n];
            for(int i =0;i<n;i++){
                parent[i] = i;
            }
            count = n;
        }
        public void union(int node1, int node2){
            int root1 = find(node1), root2 = find(node2);
            if(root1==root2) return;
            parent[root1] = root2;
            count--;
        }
        public int find(int node){
            if(parent[node]!=node){
                parent[node]=find(parent[node]);
            }
            return parent[node];
        }
        public boolean conneceted(int node1, int node2){
            return find(node1)==find(node2);
        }
        public int getCount(){
            return count;
        }
    }
}
