package graph.topologicalSorting;

import java.util.*;

class LeadsToDestinationSolution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        int[] indegree = new int[n];
        for(int[] edge : edges){
            graph[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        //如果终点还有出边, 那么从始点source出发的所有路径一定都无法到达目标终点destination
        if (indegree[destination] != 0) {
            return false;
        }
        queue.offer(destination);
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(node==source) return true;
            for(int neighbor:graph[node]){
                indegree[neighbor]--;
                //如果indegree不为0，说明还有其他节点连接这个neighbor，那么我就不走这个neighbor
                if(indegree[neighbor]==0){
                    queue.offer(neighbor);
                }
            }
        }
        return false;

    }
}
