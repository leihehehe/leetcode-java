package prefixSumAndDifference;


import java.util.HashSet;

class SplitArraySolution {
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        if (n < 7) return false; // 至少需要7个元素才能分成四个非空子数组

        // 计算前缀和
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        // 枚举第二个分割点 j -> 先枚举第二个，方便确认范围
        for (int j = 3; j < n - 3; j++) {
            HashSet<Integer> seen = new HashSet<>();
            // 枚举第一个分割点 i
            for (int i = 1; i < j - 1; i++) {
                if (prefixSum[i - 1] == prefixSum[j - 1] - prefixSum[i]) {
                    seen.add(prefixSum[i - 1]);
                }
            }
            // 枚举第三个分割点 k
            for (int k = j + 2; k < n - 1; k++) {
                if (prefixSum[n - 1] - prefixSum[k] == prefixSum[k - 1] - prefixSum[j] && seen.contains(prefixSum[n - 1] - prefixSum[k])) {
                    return true;
                }
            }
        }

        return false;
    }
}