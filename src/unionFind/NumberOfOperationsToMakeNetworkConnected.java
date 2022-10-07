package unionFind;

/***
 * Leetcode 1319
 */
public class NumberOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        int edgeNum = connections.length;
        if(n-1>connections.length){
            return -1;
        }
        int[] parent = new int[n+1];
        for(int i =1;i<=n;i++){
            parent[i]=i;
        }
        int count = 0;
        for(int i =0;i<edgeNum;i++){
            int[] connection = connections[i];
            int node1 = connection[0], node2=connection[1];
            if(find(parent,node1)==find(parent,node2)){
                count++;
            }else{
                union(parent,node1,node2);
            }
        }
        if(edgeNum>=n){
            //edgeNum-(n-1) needs to be abandoned
            count-=edgeNum-(n-1);
        }
        return count;
    }
    public int find(int[] parent, int node){
        if(node!=parent[node]){
            parent[node]=find(parent,parent[node]);
        }
        return parent[node];
    }
    public void union(int[] parent, int node1, int node2){
        parent[find(parent,node1)]=find(parent,node2);
    }
}
