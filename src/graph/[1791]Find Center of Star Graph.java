package graph;

//leetcode submit region begin(Prohibit modification and deletion)
class FindCenterOfStarGraph {
    public int findCenter(int[][] edges) {
        //n nodes
        //center of the start graph
        //indegree of n-1
        int n = edges.length+1;
        int[] indegree = new int[n+1];
        for(int[] edge:edges){
            int node1 = edge[0];
            int node2 = edge[1];
            indegree[node1]++;
            indegree[node2]++;
        }
        for(int i = 0;i<indegree.length;i++){
            if(indegree[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
