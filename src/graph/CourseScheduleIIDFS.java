package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode 210
 */
public class CourseScheduleIIDFS {
    boolean hasCycle=false;
    boolean[] path;
    boolean[] visited;
    List<Integer> postOrder = new ArrayList<>();

    /**
     * Method 1: dfs
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(!canFinish(numCourses,prerequisites)) return new int[]{};
        Collections.reverse(postOrder);
        int[] res = new int[numCourses];
        for(int i = 0;i<numCourses;i++){
            res[i]=postOrder.get(i);
        }
        return res;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites){
        path = new boolean[numCourses];
        visited = new boolean[numCourses];
        List<Integer>[] graph = buildGraph(numCourses,prerequisites);
        for(int i = 0;i<numCourses;i++){
            traverse(graph,i);
        }
        return !hasCycle;
    }

    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new LinkedList[numCourses];
        for(int i =0;i<numCourses;i++){
            graph[i] = new LinkedList<>();
        }
        for(int[] pre:prerequisites){
            int from = pre[1], to = pre[0];
            graph[from].add(to);
        }
        return graph;
    }


    public void traverse(List<Integer>[] graph, int v){
        if(path[v]) hasCycle=true;
        if(hasCycle || visited[v]) return;
        path[v]=true;
        visited[v]=true;
        for(int i =0;i<graph[v].size();i++){
            traverse(graph,graph[v].get(i));
        }
        postOrder.add(v);
        path[v]=false;
    }


}
