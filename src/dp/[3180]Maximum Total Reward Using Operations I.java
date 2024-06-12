package dp;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class MaxTotalRewardSolution1 {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        memo = new int[n][4000];
        for(int i = 0;i<memo.length;i++) Arrays.fill(memo[i], -1);
        Arrays.sort(rewardValues);
        return dfs(rewardValues, 0, 0);
    }
    int[][] memo;
    public int dfs(int[] rewardValues, int i, int sum){
        if(i == rewardValues.length) return sum;
        if(memo[i][sum]!=-1){
            return memo[i][sum];
        }
        //选
        int r1 = sum;
        if(rewardValues[i] > sum){
            int reward = sum + rewardValues[i];
            r1 = dfs(rewardValues,i+1,reward);
        }
        int r2 = dfs(rewardValues,i+1,sum);
        return memo[i][sum] = Math.max(r1,r2);
    }
}
class MaxTotalRewardSolution2 {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        int[] memo = new int[4001];
        Arrays.sort(rewardValues);
        for(int i = n;i>=0;i--){
            for(int j = 0;j<=4000;j++){
                if(i==n){
                    memo[j] = j;
                }else{
                    int r1 = j;
                    if(rewardValues[i] > j){
                        r1 = memo[j + rewardValues[i]];
                    }
                    int r2 = memo[j];
                    memo[j] = Math.max(r1,r2);
                }
            }
        }
        return memo[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
