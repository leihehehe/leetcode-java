package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Leetcode 1584
 * Another method `Kruskal` algo is implemented in the category `unionFind`
 */
public class MinCostToConnectAllPoints {
    private List<int[]>[] graph;

    /**
     * Method: Prim algo
     * @param points
     * @return
     */
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        graph = buildGraph(n, points);
        Prim prim = new Prim(graph);
        return prim.weightSum();
    }

    private List<int[]>[] buildGraph(int n, int[][] points) {
        graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                int from = i, to = j, weight = Math.abs(xi - xj) + Math.abs(yi - yj);
                graph[from].add(new int[]{from, to, weight});
                graph[to].add(new int[]{to, from, weight});
            }
        }
        return graph;
    }

    public class Prim {
        PriorityQueue<int[]> pq;
        boolean[] inMst;
        int weightSum = 0;
        private List<int[]>[] graph;

        public Prim(List<int[]>[] graph) {
            this.graph = graph;
            this.pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            int n = graph.length;
            inMst = new boolean[n];
            inMst[0] = true;
            cut(0);
            while (!pq.isEmpty()) {
                int[] edge = pq.poll();
                int to = edge[1];
                int weight = edge[2];
                if (inMst[to]) continue;
                ;
                weightSum += weight;
                inMst[to] = true;
                cut(to);
            }
        }

        public void cut(int v) {
            for (int[] edge : graph[v]) {
                int to = edge[1];
                if (inMst[to]) continue;
                pq.offer(edge);
            }
        }

        public int weightSum() {
            return weightSum;
        }

        public boolean allConnected() {
            for (int i = 0; i < inMst.length; i++) {
                if (!inMst[i]) return false;
            }
            return true;
        }
    }

}
