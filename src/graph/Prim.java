package graph;

import java.util.List;
import java.util.PriorityQueue;

public class Prim {
    private List<int[]>[] graph;
    PriorityQueue<int[]> pq;
    boolean[] inMst;
    int weightSum=0;
    public Prim(List<int[]>[] graph){
        this.graph=graph;
        this.pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        int n = graph.length;
        inMst = new boolean[n];
        inMst[0]=true;
        cut(0);
        while(!pq.isEmpty()){
            int[] edge = pq.poll();
            int to = edge[1];
            int weight = edge[2];
            if(inMst[to]) continue;;
            weightSum+=weight;
            inMst[to]=true;
            cut(to);
        }
    }

    public void cut(int v){
        for(int[] edge:graph[v]){
            int to = edge[1];
            if(inMst[to]) continue;
            pq.offer(edge);
        }
    }
    public int weightSum(){
        return weightSum;
    }
    public boolean allConnected(){
        for(int i =0;i< inMst.length;i++){
            if(!inMst[i]) return false;
        }
        return true;
    }
}
