package graph;

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
}
