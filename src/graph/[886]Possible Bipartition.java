package graph;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * DFS
 */
class PossibleBipartitionSolution1 {
    //-1 -> uncolored
    //0 -> red
    //1 -> blue
    private int[] color;
    private boolean valid = true;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //build graph
        List<Integer>[] graph = new ArrayList[n+1];
        Arrays.setAll(graph, e->new ArrayList<>());
        for(int[] dislike:dislikes){
            int p1 = dislike[0];
            int p2 = dislike[1];
            graph[p1].add(p2);
            graph[p2].add(p1);
        }
        color = new int[n+1];
        Arrays.fill(color, -1);
        for(int i = 1;i<=n;i++){
            if(color[i]==-1){
                //for every root node -> red
                dfs(graph,i,0);
            }
        }
        return valid;
    }
    public void dfs(List<Integer>[] graph, int i, int c){
        if(!valid){
            return;
        }
        List<Integer> neighbors = graph[i];
        color[i] = c;
        for(int neighbor:neighbors){
            if(color[i]==color[neighbor]){
                valid = false;
                break;
            }
            if(color[neighbor]==-1){
                dfs(graph,neighbor,color[i] ^ 1);
            }
        }
    }

}

/**
 * BFS
 */
class PossibleBipartitionSolution2 {
    //-1 -> uncolored
    //0 -> red
    //1 -> blue
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //build graph
        List<Integer>[] graph = new ArrayList[n+1];
        Arrays.setAll(graph, e->new ArrayList<>());
        for(int[] dislike:dislikes){
            int p1 = dislike[0];
            int p2 = dislike[1];
            graph[p1].add(p2);
            graph[p2].add(p1);
        }
        int[] color = new int[n+1];
        Arrays.fill(color, -1);

        Deque<Integer> queue= new ArrayDeque<>();
        for(int i = 1;i<=n;i++){
            if(color[i]==-1){
                queue.add(i);
                color[i] = 0;
                while(!queue.isEmpty()){
                    int size = queue.size();
                    for(int j=0;j<size;j++){
                        int cur = queue.poll();
                        for(int neighbor:graph[cur]){
                            if(color[neighbor]==color[cur])
                                return false;
                            else if(color[neighbor]==-1){
                                color[neighbor] = color[cur] ^ 1;
                                queue.offer(neighbor);
                            }
                        }
                    }
                }
            }

        }
        return true;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
