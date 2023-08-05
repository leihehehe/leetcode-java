package dp.sequenceDP.LIS;

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 这道题其实就是递增子序列的变形
 * 使用map能够降低复杂度，另一种方法是用双for loop,复杂度为O(n^2)
 */
class LongestArithmeticSubsequenceOfGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        // int[] dp = new int[n];
        // 以arr[i]结尾
        HashMap<Integer,Integer> dp = new HashMap<>();
        int max = 0;
        for(int i = 0;i<n;i++){
            dp.put(arr[i],dp.getOrDefault(arr[i]-difference,0)+1);
            max = Math.max(max,dp.get(arr[i]));
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
