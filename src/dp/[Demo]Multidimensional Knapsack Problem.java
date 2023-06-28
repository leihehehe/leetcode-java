package dp;

import java.util.Arrays;
class MultidimensionalKnapsackTwoDimensionalSolution {
    /**
     * two-dimensional
     * @param weight weight for each item
     * @param value values for each item
     * @param count the max time an item can be selected
     * @param capacity capacity of the knapsack
     * @return
     */
    public int maxValue(int[] weight, int[] value, int[] count, int capacity) {
        int[][] dp = new int[weight.length + 1][capacity + 1];

        for(int i = 1; i <= weight.length; i++) { // 遍历物品
            for(int j = 0; j <= capacity; j++) { // 遍历背包容量
                // 不选择第i个物品的情况
                dp[i][j] = dp[i-1][j];
                // 遍历选择第i个物品的个数
                for (int k = 1; k <= count[i-1] && (j - k * weight[i-1]) >= 0; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - k * weight[i-1]] + k * value[i-1]);
                }
            }
        }
        return dp[weight.length][capacity];
    }

    public static void main(String[] args) {
        System.out.println(new MultidimensionalKnapsackTwoDimensionalSolution().maxValue(new int[]{1, 3, 4}, new int[]{15, 20, 30}, new int[]{2, 3, 2}, 10));
        //new MultidimensionalKnapsackTwoDimensionalSolution().testMultiPack2();
    }
}
class OneDimensionalKnapsackTwoDimensionalSolution {
    /**
     * one-dimensional
     * @param weight weight for each item
     * @param value values for each item
     * @param count the max time an item can be selected
     * @param volume volume of the knapsack
     * @return
     */
    public int maxValue(int[] weight, int[] value, int[] count, int volume){
        int[] dp = new int[volume + 1];
        for(int i = 0; i < weight.length; i++) { // 遍历物品
            for(int j = volume; j >= weight[i]; j--) { // 遍历背包容量
                for (int k = 1; k <= count[i] && (j - k * weight[i]) >= 0; k++) { // 遍历个数
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
            }
        }
        return dp[volume];
    }
}
class justForTestMK{
    public void testMultiPack2(){
        // 版本二：改变遍历个数
        int[] weight = new int[] {1, 3, 4};
        int[] value = new int[] {15, 20, 30};
        int[] nums = new int[] {2, 3, 2};
        int bagWeight = 10;

        int[] dp = new int[bagWeight + 1];
        for(int i = 0; i < weight.length; i++) { // 遍历物品
            for(int j = bagWeight; j >= weight[i]; j--) { // 遍历背包容量
                // 以上为01背包，然后加一个遍历个数
                for (int k = 1; k <= nums[i] && (j - k * weight[i]) >= 0; k++) { // 遍历个数
                    dp[j] = Math.max(dp[j], dp[j - k * weight[i]] + k * value[i]);
                }
                System.out.println(Arrays.toString(dp));
            }
        }
    }
}



