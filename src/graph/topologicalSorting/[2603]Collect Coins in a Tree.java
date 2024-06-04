package graph.topologicalSorting;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class CollectTheCoinsSolution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        List<Integer>[] graph = new ArrayList[n];
        int[] indegree = new int[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for(int[] edge:edges){
            int v1 = edge[0];
            int v2 = edge[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
            indegree[v1]++;
            indegree[v2]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int rem = n;
        for(int i = 0;i<n;i++){
            //leaf node -> remove nodes having not coins
            if(indegree[i]==1 && coins[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            rem--;
            for(int neighbor : graph[node]){
                indegree[neighbor]--;
                if(coins[neighbor]==0 && indegree[neighbor]==1){
                    queue.offer(neighbor);
                }
            }
        }
        for(int i = 0;i<n;i++){
            if(indegree[i]==1 && coins[i]==1){
                queue.add(i);
            }
        }
        int res = 0;
        if(!queue.isEmpty()){
            int sz = queue.size();
            for(int i = 0;i<sz;i++){
                int curNode = queue.poll();
                rem--;
                for(int neighbor:graph[curNode]){
                    if(--indegree[neighbor]==1){
                        rem--;
                    }
                }
            }
            if(rem<1){
                res=0;
            }else{
                res=(rem-1)*2;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
