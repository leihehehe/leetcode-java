package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class CountPathsSolution {
    private final static int MODULE = (int)1e9+7;
    public int countPaths(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n];
        Arrays.setAll(graph, e->new ArrayList<>());
        for(int[] road:roads){
            graph[road[0]].add(new int[]{road[1],road[2]});
            graph[road[1]].add(new int[]{road[0],road[2]});
        }
        long[] times = new long[n];
        Arrays.fill(times, Long.MAX_VALUE);
        times[0] = 0;
        //从节点0到节点i有多少最短路个数
        int[] dp = new int[n];
        dp[0] = 1;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b)->Long.compare(a[1], b[1]));
        pq.offer(new long[]{0,0});
        while(!pq.isEmpty()){
            long[] node = pq.poll();
            int nodeIndex = (int)node[0];
            long time = node[1];
            if(time>times[nodeIndex]){
                continue;
            }
            //update neighbors
            for(int[] neighbor: graph[nodeIndex]){
                int y = neighbor[0];
                long newTime = times[nodeIndex]+neighbor[1];
                if(newTime<times[y]){
                    times[y] = newTime;
                    pq.add(new long[]{y,newTime});
                    //neighbor的最短路个数=node的最短路个数
                    dp[y] = dp[nodeIndex];
                }else if(newTime == times[y]){
                    dp[y] = (dp[y] + dp[nodeIndex]) % MODULE;
                }
            }
        }

        return dp[n-1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)
