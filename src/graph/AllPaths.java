package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Offer 110
 */
public class AllPaths {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        traverse(graph,0,new LinkedList<>());
        return res;
    }

    public void traverse(int[][] graph, int v, LinkedList<Integer> path){
        path.addLast(v);
        if(v==graph.length-1){
            res.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        for(int i = 0;i<graph[v].length;i++){
            traverse(graph,graph[v][i],path);
        }
        path.removeLast();
    }
}
