package dp;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * time-out
 */
class MinCostSolution1 {
    int[][] memo;
    public int minCost(int n, int[] cuts) {
        memo = new int[n+1][n+1];
        for(int i = 0;i<=n;i++) Arrays.fill(memo[i], -1);
        return dfs(cuts,0,n);
    }
    //minimum total cost of cuts
    public int dfs(int[] cuts, int l, int r){
        if(l==r){
            return 0;
        }
        if(l>r){
            return 0;
        }
        if(memo[l][r]!=-1) return memo[l][r];
        int res = Integer.MAX_VALUE;
        int cost = r-l;
        boolean cut = false;
        for(int i = 0;i<cuts.length;i++){
            if(cuts[i]<r && cuts[i]>l){
                cut = true;
                res = Math.min(dfs(cuts, l, cuts[i])+dfs(cuts, cuts[i], r)+cost,res);
            }
        }
        return memo[l][r] = cut?res:0;
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
