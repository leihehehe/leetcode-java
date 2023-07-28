package graph;

//leetcode submit region begin(Prohibit modification and deletion)
class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[] indegree = new int[n];
        boolean[][] connected = new boolean[n][n];

        for(int[] road:roads){
            int node1 = road[0];
            int node2 = road[1];
            indegree[node1]++;
            indegree[node2]++;
            connected[node1][node2] = true;
            connected[node2][node1] = true;

        }
        int max = 0;
        for(int i =0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                int sum = indegree[i]+indegree[j];
                //i is connected to j?
                if(connected[i][j]){
                    sum-=1;
                }
                max = Math.max(sum,max);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
