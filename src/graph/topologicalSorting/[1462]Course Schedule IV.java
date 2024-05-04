package graph.topologicalSorting;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class CheckIfPrerequisiteSolution1 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Integer>[] graph = new ArrayList[n];
        boolean[][] isPre = new boolean[n][n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        int[] indegree = new int[n];
        for(int[] pre:prerequisites){
            graph[pre[0]].add(pre[1]);
            indegree[pre[1]]++;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i =0;i<n;i++){
            if(indegree[i]==0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbor:graph[node]){
                isPre[node][neighbor] = true;
                for(int i = 0;i<n;i++){
                    if(isPre[i][node]){
                        isPre[i][neighbor] = true;
                    }
                }
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0;i<queries.length;i++){
            int[] query = queries[i];
            ans.add(isPre[query[0]][query[1]]);
        }
        return ans;
    }
}
class CheckIfPrerequisiteSolution2 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Integer>[] graph = new ArrayList[n];
        isPre = new boolean[n][n];
        finish = new boolean[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for(int[] pre:prerequisites){
            graph[pre[0]].add(pre[1]);
        }

        for(int i = 0;i<n;i++){
            if(!finish[i]) dfs(i, graph);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0;i<queries.length;i++){
            int[] query = queries[i];
            ans.add(isPre[query[0]][query[1]]);
        }
        return ans;
    }
    boolean[][] isPre;
    boolean[] finish;
    public void dfs(int i, List<Integer>[] graph){
        if(finish[i]) return;
        for(int neighbor:graph[i]){
            isPre[i][neighbor] = true;
            dfs(neighbor,graph);
            //必须在后序遍历的时候来检查neighbor和k是否有依赖，从而更新i和k之间是否有依赖。
            //因为dfs是先更新子节点的依赖状态，只有等所有子节点的依赖状态全部更新完毕后，才能更新当前的节点的依赖状态
            for(int k =0;k<isPre.length;k++){
                if(isPre[neighbor][k]) isPre[i][k] = true;
            }
        }
        finish[i] = true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
