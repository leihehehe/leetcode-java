package dp;

class KnapsackProblemTwoDimension {

    /**
     * Try to find the largest value that can be put in th knapsack
     * @param weight this is weights for each item
     * @param value this is values for each item
     * @param capacity this is the weight capacity of a knapsack
     * @return
     */
    public int maxValue(int[] weight, int[] value, int capacity){
        //the number of items
        int n = weight.length;
        //dp[i][j] -> [0..i] to be put in the bag of j bag capacity.
        int[][] dp = new int[n][capacity+1];
        //dp relation
        //put: dp[i][j] = dp[i-1][j-weight[i]]+value[i]
        //not put: dp[i][j] = dp[i-1][j]

        //Initialization for different knapsack weights
        for(int i =0;i<=capacity;i++){
            if(weight[0]<=i){
                dp[0][i] = value[0];
            }
        }
        //Initialization for different items
        for(int i = 0;i<n;i++) dp[i][0] = 0;
        for(int i = 1;i<n;i++){
            for(int j = 1;j<=capacity;j++){
                if(j<weight[i]){
                    //capacity is smaller than the item weight, do not put
                    dp[i][j] = dp[i-1][j];
                }else{
                    //put or not put
                    dp[i][j] = Math.max(dp[i-1][j-weight[i]]+value[i],dp[i-1][j]);
                }

            }

        }
        return dp[n-1][capacity];
    }

    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        System.out.println(new KnapsackProblemTwoDimension().maxValue(weight, value, bagSize));
    }


}

class KnapsackProblemOneDimension {

    /**
     * Try to find the largest value that can be put in th knapsack
     * @param weight this is weights for each item
     * @param value this is values for each item
     * @param capacity this is the weight capacity of a knapsack
     * @return
     */
    public int maxValue(int[] weight, int[] value, int capacity){
        //the number of items
        int n = weight.length;
        //dp[j] -> max value can be put in the bag of j bag capacity.
        int[] dp = new int [capacity+1];
        //dp relation
        //put: dp[j] = dp[j-weight[i]]+value[i]
        //not put: dp[j] = dp[j]

        //Initialization for different items
        for(int i = 0;i<n;i++) dp[0] = 0;
        for(int i = 1;i<n;i++){
            for(int j = capacity;j>=1;j--){
                if(j>=weight[i]){
                    //capacity is greater than the item weight
                    //put or not put
                    //dp[j-weight[i]] should keep the value from the previous row.
                    //if we traverse from the front side, dp[j-weight[i]] will have been changed.
                    dp[j] = Math.max(dp[j-weight[i]]+value[i],dp[j]);
                }
            }
        }
        return dp[capacity];
    }

    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        System.out.println(new KnapsackProblemTwoDimension().maxValue(weight, value, bagSize));
    }
}
