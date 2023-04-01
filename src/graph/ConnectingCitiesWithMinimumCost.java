package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Leetcode 1135
 * Another method `kruskal` is in the `unionFind` category
 */
public class ConnectingCitiesWithMinimumCost {
    private List<int[]>[] graph;

    /**
     * Method: prim algo
     * @param n
     * @param connections
     * @return
     */
    public int minimumCost(int n, int[][] connections) {
        graph = buildGraph(n, connections);
        Prim prim = new Prim(graph);
        if (!prim.allConnected()) return -1;
        return prim.weightSum();
    }

    private List<int[]>[] buildGraph(int n, int[][] connections) {
        graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] con : connections) {
            int from = con[0] - 1, to = con[1] - 1, weight = con[2];
            graph[from].add(new int[]{from, to, weight});
            graph[to].add(new int[]{to, from, weight});
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
