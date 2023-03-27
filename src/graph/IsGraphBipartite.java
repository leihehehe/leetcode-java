package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode 785
 */
public class IsGraphBipartite {
    private boolean bipartite = true;
    //true->first color/ false-> second color
    private boolean[] color;
    private boolean[] visited;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new boolean[n];
        visited = new boolean[n];
        for(int i = 0;i<n;i++){
            if(!visited[i]) traverse(graph,i);
        }
        return bipartite;
    }

    /**
     * Method 1: dfs
     * @param graph
     * @param v
     */
    public void traverse(int[][] graph, int v){
        //if not bipartite
        if(!bipartite) return;
        visited[v] = true;
        for(int i=0;i<graph[v].length;i++){
            if(!visited[graph[v][i]]){
                color[graph[v][i]]=!color[v];
                traverse(graph,graph[v][i]);
            }else{
                if(color[v]==color[graph[v][i]]){
                    bipartite=false;
                    return;
                }
            }

        }
    }

    /**
     * Method 2: BFS
     * @param graph
     * @param start
     */
    public void traverseBFS(int[][] graph, int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty() ){
            int v = queue.poll();
            for(int neighbour:graph[v]){
                if(!visited[neighbour]){
                    color[neighbour]=!color[v];
                    visited[neighbour]=true;
                    queue.offer(neighbour);
                }else{
                    if(color[neighbour]==color[v]){
                        bipartite = false;
                        return;
                    }
                }
            }
        }
    }

}
