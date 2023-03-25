package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode 210 - bfs solution
 */
public class CourseScheduleIIBFS {
    boolean hasCycle=false;
    boolean[] path;
    boolean[] visited;
    List<Integer> postOrder = new ArrayList<>();
    int[] res;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(!canFinish(numCourses,prerequisites)) return new int[]{};

        return res;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites){
        List<Integer>[] graph = buildGraph(numCourses,prerequisites);
        int[] indegree = new int[numCourses];
        res = new int[numCourses];
        for(int[] edge : prerequisites){
            int from = edge[1], to = edge[0];
            indegree[to]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int v = queue.poll();
            res[count]=v;
            count ++;
            for(int neighbour:graph[v]){
                indegree[neighbour]--;
                if(indegree[neighbour]==0) queue.offer(neighbour);
            }
        }
        return count==numCourses;
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
