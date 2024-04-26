package others;

class LongestNondecreasingSubarrayFromTwoArrays {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {

        int n = nums1.length;
        //以nums1[i]结尾的最长非递增子数组
        int[] dp1 = new int[n];
        //以nums2[i]结尾的最长非递增子数组
        int[] dp2 = new int[n];
        int res = 1;
        for (int i = 0; i < n; i++) {
            dp1[i] = 1;
            dp2[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (nums1[i - 1] <= nums1[i])
                dp1[i] = dp1[i - 1] + 1;
            if (nums2[i - 1] <= nums1[i])
                dp1[i] = Math.max(dp1[i], dp2[i - 1] + 1);
            if (nums2[i - 1] <= nums2[i])
                dp2[i] = dp2[i - 1] + 1;
            if (nums1[i - 1] <= nums2[i])
                dp2[i] = Math.max(dp2[i], dp1[i - 1] + 1);
            res = Math.max(Math.max(res, dp1[i]), dp2[i]);
        }
        return res;
    }
}
