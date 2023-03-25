package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode 797
 */
public class AllPathsFromSourceToTarget {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    public void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        path.addLast(s);
        if (s == graph.length - 1) {
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        //access all neighbors of vertex `s`
        for (int i = 0; i < graph[s].length; i++) {
            traverse(graph, graph[s][i], path);
        }
        path.removeLast();
    }
}
