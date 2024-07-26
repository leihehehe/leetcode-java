package prefixSumAndDifference;

class CanEatSolution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long[] preSum = new long[n+1];
        for(int i = 0;i<n;i++){
            preSum[i+1] = preSum[i] + candiesCount[i];
        }
        boolean[] ans = new boolean[queries.length];
        for(int i = 0 ;i<queries.length;i++){
            int favoriteType = queries[i][0];
            //下面算出来的day是1-indexed，所以我们要给当前的day+1变为1-indexed
            int favoriteDay = queries[i][1]+1;
            int dailyCap = queries[i][2];
            //下面算出来的day是1-indexed
            //最快速度来吃，最早能在第earlistDay【吃到】我想吃的【第一颗糖】
            long earliestDay = preSum[favoriteType] / dailyCap + 1;
            //最慢速度来吃，最晚能在第latestDay【吃到】我想吃的【最后一颗糖】
            long latestDay = preSum[favoriteType + 1];
            ans[i] = earliestDay <= favoriteDay && favoriteDay <= latestDay;
        }
        return ans;
    }
}