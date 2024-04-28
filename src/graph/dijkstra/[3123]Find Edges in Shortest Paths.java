package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class FindAnswerSolution1 {
    public boolean[] findAnswer(int n, int[][] edges) {
        int m = edges.length;
        List<int[]>[] graph = new ArrayList[n];
        Arrays.setAll(graph, e->new ArrayList<>());
        for(int i = 0;i<edges.length;i++){
            int[] edge = edges[i];
            graph[edge[0]].add(new int[]{edge[1],edge[2],i});
            graph[edge[1]].add(new int[]{edge[0],edge[2],i});
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b)->Long.compare(a[1],b[1]));
        long[] dis = new long[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0] = 0;
        pq.offer(new long[]{0,0});
        while(!pq.isEmpty()){
            long[] node = pq.poll();
            int index = (int)node[0];
            long weight = node[1];
            if(weight>dis[index]){
                continue;
            }
            //update neighbors
            for(int[] neighbor:graph[index]){
                long newDis = dis[index]+neighbor[1];
                if(newDis<dis[neighbor[0]]){
                    dis[neighbor[0]] = newDis;
                    pq.offer(new long[]{neighbor[0],newDis});
                }

            }
        }
        boolean[] ans = new boolean[m];
        if(dis[n-1]==Long.MAX_VALUE) return ans;
        visited = new boolean[n];
        dfs(graph,ans,dis,n-1);
        return ans;
    }
    boolean[] visited;
    public void dfs(List<int[]>[] graph, boolean[] ans, long[] dis, int x){
        visited[x] = true;
        for(int[] neighbor:graph[x]){
            int index = neighbor[0];
            int weight = neighbor[1];
            int i = neighbor[2];
            //因为x是从n-1出发的，所以如果dis[x] == dis[index] + weight，说明这个neighbor是在最短路上的。
            if(dis[x] == dis[index] + weight){
                ans[i] = true;
                if(!visited[index]){
                    dfs(graph,ans,dis,index);
                }
            }

        }
    }
}

class FindAnswerSolution2 {
    public boolean[] findAnswer(int n, int[][] edges) {
        int m = edges.length;
        List<int[]>[] graph = new ArrayList[n];
        Arrays.setAll(graph,e->new ArrayList<>());
        for(int i = 0;i<edges.length;i++){
            int[] edge = edges[i];
            graph[edge[0]].add(new int[]{edge[1],edge[2],i});
            graph[edge[1]].add(new int[]{edge[0],edge[2],i});
        }

        //双向dijkstra
        long[] startToEndDis = dijkstra(0,graph,n);
        long[] endToStartDis = dijkstra(n-1,graph,n);
        boolean[] ans = new boolean[m];
        if(startToEndDis[n-1]==Long.MAX_VALUE) return ans;

        for(int i = 0;i<edges.length;i++){
            int[] edge = edges[i];
            int u = edge[0],v = edge[1],w = edge[2];
            if((startToEndDis[u] + endToStartDis[v] + w == startToEndDis[n-1]) || (startToEndDis[v] + endToStartDis[u]+ w == startToEndDis[n-1] )){
                ans[i] = true;
            }
        }

        return ans;
    }

    public long[] dijkstra(int start, List<int[]>[] graph, int n){
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        pq.offer(new long[]{start,0});
        long[] dis = new long[n];
        Arrays.fill(dis,Long.MAX_VALUE/2);
        dis[start] = 0;

        while(!pq.isEmpty()){
            long[] node = pq.poll();
            int index = (int)node[0];
            long weight = node[1];
            if(weight>dis[index]){
                continue;
            }
            //update neighbors
            for(int[] neighbor:graph[index]){
                long newDis = dis[index]+neighbor[1];
                if(newDis<dis[neighbor[0]]){
                    dis[neighbor[0]] = newDis;
                    pq.offer(new long[]{neighbor[0],newDis});
                }

            }
        }
        return dis;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
