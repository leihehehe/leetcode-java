package graph.topologicalSorting;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class FindOrderSolution1 {
    boolean hasCycle;
    boolean[] finish;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[numCourses];
        finish = new boolean[numCourses];
        Arrays.setAll(graph, e->new ArrayList<>());
        for(int[] pre:prerequisites){
            graph[pre[1]].add(pre[0]);
        }
        for(int i = 0;i<numCourses;i++){
            if(!finish[i] && !hasCycle){
                dfs(i,graph,new boolean[numCourses],res);
            }
        }
        if(hasCycle) return new int[]{};
        int[] finalRes = new int[numCourses];
        for(int i = 0,j=numCourses-1;i<numCourses;i++,j--){
            finalRes[i] = res.get(j);
        }
        return finalRes;
    }
    public void dfs(int i, List<Integer>[] graph, boolean[] visited,List<Integer> res){
        if(finish[i] || hasCycle) return;
        if(visited[i]){
            hasCycle = true;
            return;
        }
        visited[i] = true;
        for(int neighbor:graph[i]){
            dfs(neighbor,graph,visited,res);
        }
        finish[i] = true;
        res.add(i);
    }
}
class FindOrderSolution2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        Arrays.setAll(graph, e -> new ArrayList<>());
        int[] indegree = new int[numCourses];
        for(int[] pre:prerequisites){
            graph[pre[1]].add(pre[0]);
            indegree[pre[0]]++;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i = 0;i<numCourses;i++){
            if(indegree[i]==0)
                queue.offer(i);
        }
        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            res[count++] = node;
            for(int neighbor:graph[node]){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    queue.offer(neighbor);
                }
            }
        }
        if(count!=numCourses) return new int[]{};

        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
