package graph.topologicalSorting;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class FindMinHeightTreesSolution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //bfs
        //build graph
        ArrayList<Integer> res = new ArrayList<>();
        if(n==1){
            res.add(0);
            return res;
        }
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, e->new ArrayList<>());
        int[] indegree = new int[n];
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
            indegree[edge[1]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 0;i<n;i++){
            if(indegree[i]==1) queue.offer(i);
        }
        int remainingNodes = n;
        while(remainingNodes>2){
            int size = queue.size();
            remainingNodes-=size;
            for(int i = 0;i<size;i++){
                int node = queue.poll();
                for(int neighbor: graph[node]){
                    indegree[neighbor]--;
                    if(indegree[neighbor]==1) queue.offer(neighbor);
                }
            }
        }
        while(!queue.isEmpty()){
            res.add(queue.poll());
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
