package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class ShortestPathGraphSolution1 {
    private final static int INF = Integer.MAX_VALUE/2;
    int[][] graph;
    int n;
    public ShortestPathGraphSolution1(int n, int[][] edges) {
        this.graph = new int[n][n];
        this.n = n;
        for(int[] g:graph) Arrays.fill(g, INF);
        for(int[] edge:edges){
            graph[edge[0]][edge[1]]=edge[2];
        }

    }

    public void addEdge(int[] edge) {
        graph[edge[0]][edge[1]]= edge[2];
    }

    public int shortestPath(int node1, int node2) {
        //finally -> the shortest distances between node1 and any other nodes
        int[] dis = new int[n];
        boolean[] done = new boolean[n];
        Arrays.fill(dis, INF);
        dis[node1] = 0;
        while(true){
            //first find out the node has the shortest path
            int minNode = -1;
            for(int i = 0;i<n;i++){
                if(!done[i] && (minNode==-1 || dis[i] < dis[minNode]) ){
                    minNode = i;
                }
            }
            if(minNode == node2){
                //we found the shortest path of node 2
                //if distance is INF, this means no path exists
                return dis[minNode]==INF? -1:dis[minNode];
            }
            //all the node has been accessed, but does not find node 2
            if(minNode == -1){
                return -1;
            }
            done[minNode] = true;
            //update neighbors distances
            for(int i =0;i<n;i++){
                dis[i] = Math.min(dis[i],dis[minNode]+graph[minNode][i]);
            }
        }
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
class ShortestPathGraphSolution2 {
    private final static int INF = Integer.MAX_VALUE/2;
    List<int[]>[] graph;
    int n;
    public ShortestPathGraphSolution2(int n, int[][] edges) {
        this.graph = new ArrayList[n];
        Arrays.setAll(graph,i->new ArrayList<>());
        this.n = n;
        for(int[] edge:edges){
            graph[edge[0]].add(new int[]{edge[1],edge[2]});
        }

    }
    public void addEdge(int[] edge) {
        graph[edge[0]].add(new int[]{edge[1],edge[2]});
    }
    public int shortestPath(int node1, int node2) {
        //finally -> the shortest distances between node1 and any other nodes
        int[] dis = new int[n];
        Arrays.fill(dis, INF);
        dis[node1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
        pq.offer(new int[]{node1, 0});
        while(!pq.isEmpty()){
            int[] node =pq.poll();
            int nodeIndex = node[0];
            int nodeDis = node[1];
            if(nodeDis>dis[nodeIndex]){
                continue;
            }
            if(nodeIndex == node2){
                return dis[node2]==INF? -1:dis[node2];
            }
            //update neighbors
            for(int[] neighbor: graph[nodeIndex]){
                if(dis[neighbor[0]]>dis[nodeIndex]+neighbor[1]){
                    dis[neighbor[0]] = dis[nodeIndex]+neighbor[1];
                    pq.add(new int[]{neighbor[0],dis[neighbor[0]]});
                }
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
//leetcode submit region end(Prohibit modification and deletion)
