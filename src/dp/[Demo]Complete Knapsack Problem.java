package dp;

class CompleteKnapsackProblemBasicDeduction {
    /**
     * Question: what is the largest value when putting items into the knapsack?
     * Notice: Every type of items have infinite numbers to be picked
     * @param N the number of item types
     * @param C the capacity of the knapsack
     * @param v the values of each item
     * @param w the weights of each item
     * @return
     */
    private int maxValue(int N, int C, int[] v, int[] w){
        int[][] dp = new int[N+1][C+1];
        for(int i = 1;i<=N;i++){
            for(int j =0;j<=C;j++){
                //不选
                if(w[i-1]>j) {
                    dp[i][j] = dp[i - 1][j];
                }else{
                    for(int k = 1;;k++){
                        if(j<w[i-1]*k){
                            break;
                        }
                        dp[i][j] = Math.max(dp[i][j],Math.max(dp[i-1][j],dp[i-1][j-k*w[i-1]]+k*v[i-1]));
                    }

                }
            }
        }
        return dp[N][C];
    }

}
class CompleteKnapsackProblemFinalTemplate {
    /**
     * Question: what is the largest value when putting items into the knapsack?
     * Notice: Every type of items have infinite numbers to be picked
     * @param N the number of item types
     * @param C the capacity of the knapsack
     * @param v the values of each item
     * @param w the weights of each item
     * @return
     */
    private int maxValue(int N, int C, int[] v, int[] w){
        int[][] dp = new int[N+1][C+1];
        for(int i = 1;i<=N;i++){
            for(int j =0;j<=C;j++){
                //不选
                if(w[i-1]>j) {
                    dp[i][j] = dp[i - 1][j];
                }else{
                    //dp[i][j-w[i-1]]+v[i-1] => assume that we have put item i into the knapsack
                    dp[i][j] = Math.max(dp[i][j],dp[i][j-w[i-1]]+v[i-1]);
                }
            }
        }
        return dp[N][C];
    }

}