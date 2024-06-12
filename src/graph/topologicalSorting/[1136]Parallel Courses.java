package graph.topologicalSorting;

import java.util.*;

class MinimumSemestersSolution {
    public int minimumSemesters(int n, int[][] relations) {
        List<Integer>[] graph = new ArrayList[n+1];
        int[] indegree = new int[n+1];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for(int[] relation:relations){
            graph[relation[0]].add(relation[1]);
            indegree[relation[1]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1;i<=n;i++){
            if(indegree[i]==0) queue.offer(i);
        }
        int count = 0;
        int finished = 0;
        while(!queue.isEmpty()){
            int sz = queue.size();
            count++;
            for(int i = 0;i<sz;i++){
                int node = queue.poll();
                finished++;
                for(int neighbor:graph[node]){
                    indegree[neighbor]--;
                    if(indegree[neighbor]==0) queue.offer(neighbor);
                }
            }
        }
        if(finished!=n) return -1;
        return count;
    }
}
