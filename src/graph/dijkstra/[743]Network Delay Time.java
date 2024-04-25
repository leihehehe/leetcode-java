package graph.dijkstra;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 稠密图用邻接表
 */
class NetworkDelayTimeSolution1 {
    //prevent overflow
    final static int INF = Integer.MAX_VALUE/2;
    public int networkDelayTime(int[][] times, int n, int k) {
        //graph
        int[][] graph = new int[n][n];
        for(int[] g: graph) Arrays.fill(g,INF);
        for(int[] time:times){
            graph[time[0]-1][time[1]-1] = time[2];
        }
        //distance between k and other nodes
        int[] dis = new int[n];
        Arrays.fill(dis,INF);
        dis[k-1] = 0;
        boolean[] done = new boolean[n];
        int lastDis = 0;
        while(true){
            //get the node with the shortest path from dis
            int node = -1;
            for(int i = 0;i<n;i++){
                if(!done[i] && (node==-1 || dis[i]<dis[node])){
                    node = i;
                }
            }
            if(node == -1){
                return lastDis;
            }
            if(dis[node]==INF){
                return -1;
            }
            done[node] = true;
            lastDis = dis[node];
            //update neighbors
            for(int i = 0;i<n;i++){
                dis[i] = Math.min(dis[i],dis[node]+graph[node][i]);
            }
        }
    }
}
class NetworkDelayTimeSolution2 {
    private final static int INF = Integer.MAX_VALUE/2;
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n];
        Arrays.setAll(graph, i->new ArrayList<>());
        for(int[] time: times){
            graph[time[0]-1].add(new int[]{time[1]-1,time[2]});
        }
        int[] dis = new int[n];
        Arrays.fill(dis, INF);
        dis[k-1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
        pq.offer(new int[]{k-1,0});
        int remain = n;
        int lastDis = 0;
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int curIndex = node[0];
            int curDis = node[1];
            if(curDis>dis[curIndex]){
                continue;
            }
            remain--;
            lastDis = curDis;
            //update neighbor
            for(int[] neighbor : graph[curIndex]){
                int index = neighbor[0];
                if(neighbor[1]+curDis < dis[index]){
                    dis[index] = neighbor[1]+curDis;
                    pq.add(new int[]{index,dis[index]});
                }
            }
        }
        return remain==0? lastDis:-1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
