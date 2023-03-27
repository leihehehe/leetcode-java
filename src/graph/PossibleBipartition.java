package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PossibleBipartition {
    private boolean bipartite=true;
    private boolean color[];
    private boolean visited[];
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = buildGraph(n,dislikes);
        color= new boolean[n+1];
        visited=new boolean[n+1];
        for(int i =1;i<n+1;i++){
            if(!visited[i]&&bipartite) traverse(graph,i);
            //if(!visited[i]&&bipartite) bfs(graph,i);
        }
        return bipartite;
    }
    public List<Integer>[] buildGraph(int n, int[][] dislikes){
        List<Integer>[] graph = new LinkedList[n+1];
        for(int i =1;i<n+1;i++){
            graph[i] = new LinkedList<>();
        }
        for(int i =0;i<dislikes.length;i++){
            int who = dislikes[i][0], hated = dislikes[i][1];
            graph[who].add(hated);
            graph[hated].add(who);
        }
        return graph;
    }

    /**
     * Method 1: dfs
     * @param graph
     * @param v
     */
    public void traverse(List<Integer>[] graph, int v){
        if(!bipartite) return;
        visited[v] = true;
        for(int i = 0;i<graph[v].size();i++){
            int neighbour = graph[v].get(i);
            if(!visited[neighbour]){
                visited[neighbour]=true;
                color[neighbour]=!color[v];
                traverse(graph,neighbour);
            }else{
                if(color[neighbour]==color[v]){
                    bipartite=false;
                    return;
                }
            }
        }
    }

    /**
     * Method 2: bfs
     * @param graph
     * @param start
     */
    public void bfs(List<Integer>[] graph, int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start]=true;
        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int neighbor : graph[v]){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    color[neighbor]=!color[v];
                    queue.offer(neighbor);
                }else{
                    if(color[neighbor]==color[v]){
                        bipartite=false;
                        return;
                    }
                }
            }
        }
    }
}
