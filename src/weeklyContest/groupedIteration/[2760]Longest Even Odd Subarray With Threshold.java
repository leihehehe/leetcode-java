package weeklyContest.groupedIteration;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestAlternatingSubarray {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int i = 0;
        int n = nums.length;
        int max = 0;
        while(i<n){
            if(nums[i]>threshold || nums[i]%2!=0){
                i++;
                continue;
            }
            int start = i;
            i++;
            while(i<n && nums[i]%2!= nums[i-1]%2 && nums[i]<=threshold){
                i++;
            }
            max = Integer.max(i-start,max);

        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
