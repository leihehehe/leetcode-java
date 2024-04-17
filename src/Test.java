import java.util.*;

public class Test {
    public static void main(String[] args) {
//        String s = "[[1,0,0,0,0,0,0,0,1],[0,1,0,1,0,0,0,0,0],[0,0,1,1,0,1,0,0,0],[0,1,1,1,1,0,1,0,0],[0,0,0,1,1,1,0,0,0],[0,0,1,0,1,1,0,0,0],[0,0,0,1,0,0,1,1,0],[0,0,0,0,0,0,1,1,1],[1,0,0,0,0,0,0,1,1]]\n";
//        s = s.replace('[','{').replace(']','}');
//        System.out.println(s);
        Test test = new Test();
        int[][] graph = new int[][]{{1,0,0,0,0,0,0,0,1},{0,1,0,1,0,0,0,0,0},{0,0,1,1,0,1,0,0,0},{0,1,1,1,1,0,1,0,0},{0,0,0,1,1,1,0,0,0},{0,0,1,0,1,1,0,0,0},{0,0,0,1,0,0,1,1,0},{0,0,0,0,0,0,1,1,1},{1,0,0,0,0,0,0,1,1}};
        System.out.println(test.minMalwareSpread(graph, new int[]{3, 7}));
    }

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        boolean[] isInfected = new boolean[n];
        for (int init : initial) {
            isInfected[init] = true;
        }
        UnionFind uf = new UnionFind(n);
        //得到没有被感染的连通块
        for (int i = 0; i < n; i++) {
            if (isInfected[i]) continue;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (graph[i][j] == 1 && !isInfected[j] && !uf.isConnected(i, j)) {
                    uf.union(i, j);
                }
            }
        }
        int maxNotInfectedNodes = Integer.MIN_VALUE;
        int minIndexNode = n;
        boolean[] visited = new boolean[n];
        //key: 没有被感染的node(root), value:被感染node的邻居个数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int infected : initial) {
            boolean[] counted = new boolean[n];
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (neighbor == infected || graph[infected][neighbor] == 0 || isInfected[neighbor]) continue;
                int root = uf.find(neighbor);
                if(!counted[root]){
                    counted[root] = true;
                    countMap.put(root, countMap.getOrDefault(root, 0) + 1);
                }
            }
        }
        for (int infected : initial) {
            int notInfectedNodes = 0;
            //避免重复统计同一group的数量
            Arrays.fill(visited, false);
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (neighbor == infected || graph[infected][neighbor] == 0 || isInfected[neighbor]) continue;
                int root = uf.find(neighbor);
                if (!visited[root]) {
                    visited[root] = true;
                    if (countMap.get(root) == 1)
                        notInfectedNodes += uf.getSize(root);
                }
            }
            if (notInfectedNodes > maxNotInfectedNodes) {
                maxNotInfectedNodes = notInfectedNodes;
                minIndexNode = infected;
            } else if (notInfectedNodes == maxNotInfectedNodes && infected < minIndexNode) {
                minIndexNode = infected;
            }
        }
        return minIndexNode;

    }

    class UnionFind {
        int[] count;
        int[] parent;

        public UnionFind(int n) {
            this.count = new int[n];
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            Arrays.fill(count, 1);
        }

        public boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                count[rootJ] += count[rootI];
            }

        }

        public int getSize(int i) {
            return count[i];
        }

    }

}
