package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class MaxProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<double[]>[] graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for(int i = 0;i<edges.length;i++){
            int[] edge = edges[i];
            double prob = succProb[i];
            graph[edge[0]].add(new double[]{edge[1],prob});
            graph[edge[1]].add(new double[]{edge[0],prob});
        }
        double[] probs = new double[n];
        Arrays.fill(probs, 0);
        probs[start_node] = 1;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->Double.compare(b[1], a[1]));
        pq.offer(new double[]{start_node,1});
        while(!pq.isEmpty()){
            double[] node = pq.poll();
            int nodeIndex = (int)node[0];
            double nodeProb = node[1];
            if(probs[nodeIndex]>nodeProb){
                continue;
            }
            if(nodeIndex == end_node){
                return probs[nodeIndex];
            }
            //update neighbors
            for(double[] neighbor:graph[nodeIndex]){
                int index = (int)neighbor[0];
                double newProb = probs[nodeIndex] * neighbor[1];
                if(newProb > probs[index]){
                    probs[index] = newProb;
                    pq.add(new double[]{index,probs[index]});
                }
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
