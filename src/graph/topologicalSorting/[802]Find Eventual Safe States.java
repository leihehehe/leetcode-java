package graph.topologicalSorting;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class EventualSafeNodesSolution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] indegree = new int[n];
        List<Integer>[] newGraph = new ArrayList[n];
        Arrays.setAll(newGraph, e->new ArrayList<>());
        for(int i = 0;i<n;i++){
            for(int neighbor:graph[i]){
                newGraph[neighbor].add(i);
                indegree[i]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0;i<n;i++){
            if(indegree[i]==0){
                queue.offer(i);
                // res.add(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbor:newGraph[node]){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    // res.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        // Collections.sort(res);
        for(int i = 0;i<n;i++){
            if(indegree[i]==0) res.add(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
