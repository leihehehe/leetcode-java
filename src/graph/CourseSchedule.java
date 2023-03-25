package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode 207
 */
public class CourseSchedule {
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle=false;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //[0,1]=>1->0
        List<Integer>[] graph = buildGraph(numCourses,prerequisites);
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        for(int i = 0;i<numCourses;i++){
            traverse(graph,i);
        }
        return !hasCycle;
    }

    public void traverse(List<Integer>[] graph, int v){
        if(onPath[v]) hasCycle=true;
        if(visited[v] || hasCycle){
            //found cycle
            return;
        }
        visited[v] = true;
        onPath[v] = true;
        for(int vertex: graph[v]){
            traverse(graph,vertex);
        }
        onPath[v]=false;

    }

    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = new LinkedList[numCourses];
        for(int i = 0;i<numCourses;i++){
            graph[i] = new LinkedList<>();
        }
        for(int[] edge: prerequisites){
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}
