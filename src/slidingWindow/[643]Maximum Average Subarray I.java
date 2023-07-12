package slidingWindow;

//leetcode submit region begin(Prohibit modification and deletion)
class MaximumAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0, r = 0;
        int sum = 0;
        double maxSum = Integer.MIN_VALUE;
        while(r<nums.length){
            int toAdd = nums[r];
            r++;
            sum+=toAdd;
            while(r-l>k){
                int toRemove = nums[l];
                l++;
                sum-=toRemove;
            }
            if(r-l==k){
                maxSum = Math.max(maxSum,sum);
            }

        }
        return maxSum/k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
