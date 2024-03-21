package dp;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * time-out
 */
class MinCostSolution1 {
    int[][] memo;
    public int minCost(int n, int[] cuts) {
        //0,1,3,4,5,7
        Arrays.sort(cuts);
        int len = cuts.length+2;
        int[] arr = new int[len];
        arr[0] = 0;
        for(int i = 1;i<len-1;i++){
            arr[i] = cuts[i-1];
        }
        arr[len-1] = n;
        memo = new int[len][len];
        for(int i = 0;i<len;i++) Arrays.fill(memo[i], -1);

        return dfs(arr,0,len-1);
    }
    public int dfs(int[] arr, int l, int r){
        //没有切割点了，只剩一个长度为1的棍子了
        if(l+1>=r){
            return 0;
        }
        if(memo[l][r]!=-1) return memo[l][r];
        int res = Integer.MAX_VALUE;
        //排除掉左右边界，左右边界不作为切割点
        for(int i = l+1;i<r;i++){
            res = Math.min(res,dfs(arr,l,i)+dfs(arr,i,r)+arr[r]-arr[l]);
        }
        return memo[l][r] = res;
    }
}

class MinCostSolution2 {
    public int minCost(int n, int[] cuts) {
        int len = cuts.length+2;
        int[][] memo = new int[len][len];
        Arrays.sort(cuts);
        int[] newCuts = new int[len];
        newCuts[0] = 0;
        newCuts[len-1] = n;
        for(int i = 0;i<cuts.length;i++){
            newCuts[i+1] = cuts[i];
        }
        for(int i = len-1;i>=0;i--){
            for(int j = i+1;j<=len-1;j++){
                int cost = newCuts[j] - newCuts[i];
                memo[i][j] = Integer.MAX_VALUE;
                for(int k = i+1;k<j;k++){
                    //[1,3,4,5]
                    memo[i][j] = Math.min(memo[i][k]+memo[k][j]+cost,memo[i][j]);
                }
                memo[i][j] = memo[i][j]==Integer.MAX_VALUE?0:memo[i][j];
            }
        }

        return memo[0][len-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
