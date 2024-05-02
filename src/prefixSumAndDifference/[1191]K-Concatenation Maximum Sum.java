package prefixSumAndDifference;

//leetcode submit region begin(Prohibit modification and deletion)
class KConcatenationMaxSumSolution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        long maxOfEnd = arr[0] > 0 ? arr[0] : 0L, maxSoFar = maxOfEnd, sum = arr[0];
        for (int i = 1; i < Math.min(k, 2) * arr.length; i++) {
            maxOfEnd = Math.max(maxOfEnd + arr[i % arr.length], arr[i % arr.length]);
            maxSoFar = Math.max(maxOfEnd, maxSoFar);
            if (i < arr.length) sum += arr[i];
        }
        if (sum > 0 && k > 2) {
            long r = (sum * (k - 2)) % 1000000007;
            maxSoFar += r;
        }
        return (int) maxSoFar % 1000000007;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
