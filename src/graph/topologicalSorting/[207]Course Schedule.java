package graph.topologicalSorting;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class CourseScheduleSolution1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        Arrays.setAll(graph, e->new ArrayList<>());
        int[] indegree = new int[numCourses];
        for(int[] pre:prerequisites){
            graph[pre[1]].add(pre[0]);
            indegree[pre[0]]++;
        }
        //从入度为0的开始找
        int count = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i = 0;i<numCourses;i++){
            if(indegree[i]==0)
                queue.offer(i);
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbor:graph[node]){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    queue.offer(neighbor);
                }
            }
            count++;
        }
        return count == numCourses;
    }
}
class CourseScheduleSolution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        Arrays.setAll(graph,e->new ArrayList<>());
        for(int[] pre:prerequisites){
            graph[pre[1]].add(pre[0]);
        }
        finish = new boolean[numCourses];
        for(int i = 0;i<numCourses;i++){
            if(!finish[i] && !hasCycle){
                boolean[] visited = new boolean[numCourses];
                dfs(i,graph,visited);
            }

        }
        return !hasCycle;
    }
    boolean[] finish;
    boolean hasCycle;
    public void dfs(int i,List<Integer>[] graph, boolean[] visited){
        if(hasCycle || finish[i]) return;
        if(visited[i]){
            hasCycle = true;
            return;
        }
        visited[i] = true;
        for(int neighbor:graph[i]){
            dfs(neighbor,graph,visited);
        }
        finish[i] = true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
