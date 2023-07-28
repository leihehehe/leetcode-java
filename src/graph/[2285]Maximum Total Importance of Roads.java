package graph;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class MaximumTotalImportanceOfRoads {
    public long maximumImportance(int n, int[][] roads) {
        //we can assign the larger values to the nodes who has larger indegree
        //node -> indegree
        long[] indegree = new long[n];

        for(int[] road:roads){
            int node1 = road[0];
            int node2 = road[1];
            indegree[node1]++;
            indegree[node2]++;
        }
        Arrays.sort(indegree);
        long ans = 0;
        int value = n;
        for(int i = n-1;i>=0;i--){
            ans+= value * indegree[i];
            value--;
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
