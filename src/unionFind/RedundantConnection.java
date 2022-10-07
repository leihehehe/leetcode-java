package unionFind;

/***
 * Leetcode 684
 * Time complexity: O(nlogn) -> need to iterate every edge(n), and for every edge, need to find their roots
 * Space complexity: O(n) -> parent[]
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (find(parent, node1) != find(parent, node2)) {
                union(parent, node1, node2);
            } else {
                return edge;
            }
        }
        return new int[0];

    }

    public int find(int[] parent, int node) {
        if (node != parent[node]) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
        // while(node != parent[node]){
        //     node = parent[node];
        // }
        // return node;
    }

    public void union(int[] parent, int node1, int node2) {
        int rootNode1 = find(parent, node1);
        int rootNode2 = find(parent, node2);
        parent[rootNode1] = rootNode2;
    }

}
