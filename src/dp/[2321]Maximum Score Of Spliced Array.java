package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class MaximumsSplicedArraySolution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(solve(nums1,nums2),solve(nums2,nums1));
    }
    public int solve(int[] nums1, int[] nums2){
        int n = nums1.length;
        int sum = 0;
        int prev = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            sum+=nums1[i];
            prev = Math.max(prev+nums2[i]-nums1[i],nums2[i]-nums1[i]);
            max = Math.max(max,prev);
        }
        return sum+max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
