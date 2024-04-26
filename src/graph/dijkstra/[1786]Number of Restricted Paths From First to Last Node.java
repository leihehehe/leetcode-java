package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class CountRestrictedPathsSolution {
    private final static int MODULE = (int)1e9+7;
    public int countRestrictedPaths(int n, int[][] edges) {
        List<int[]>[] graph = new ArrayList[n];
        Arrays.setAll(graph, e->new ArrayList<>());
        for(int[] edge:edges){
            graph[edge[0]-1].add(new int[]{edge[1]-1,edge[2]});
            graph[edge[1]-1].add(new int[]{edge[0]-1,edge[2]});
        }
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[n-1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
        pq.offer(new int[]{n-1,0});
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int index = node[0], curDis = node[1];
            if(curDis>dis[index]){
                continue;
            }
            //update neighbors
            for(int[] neighbor: graph[index]){
                int newDis = neighbor[1] + dis[index];
                if(newDis<dis[neighbor[0]]){
                    dis[neighbor[0]] = newDis;
                    pq.add(new int[]{neighbor[0],newDis});
                }
            }
        }
        //算出来n到每个节点的最短距离后，计算restricted path
        //dist = [4,2,1,6,0]
        //单调递减到最后一个数，求有多少种选择，但同时要满足有edge
        //dp[i] = dp[j] + 1
        //dist[j] > dist[i] 且j和i之间有edge
        memo = new int[n];
        Arrays.fill(memo,-1);
        return dfs(n-1,graph,n,dis);
    }
    int[] memo;
    //从n-1开始，单调递增到第一个数
    public int dfs(int i, List<int[]>[] graph, int n, int[] dis){
        if(i==0) return 1;
        if(memo[i]!=-1) return memo[i];
        int res = 0;
        for(int[] neighbor:graph[i]){
            int index = neighbor[0];
            // if(visited[index]) continue;
            if(dis[index]>dis[i]){
                res = (res + dfs(index,graph,n,dis))%MODULE;
            }
        }
        return memo[i] = res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
