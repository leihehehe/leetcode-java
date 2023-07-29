package graph;

//leetcode submit region begin(Prohibit modification and deletion)
class NodeWithHighestEdgeScore {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] sum = new long[n];
        for(int i=0;i<n;i++){
            sum[edges[i]]+=i;
        }
        int maxIndex = 0;
        for(int i = 0;i<n;i++){
            if(sum[maxIndex]<sum[i]){
                maxIndex = i;
            }else if(sum[maxIndex]==sum[i]){
                maxIndex = Math.min(maxIndex,i);
            }
        }
        return maxIndex;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
