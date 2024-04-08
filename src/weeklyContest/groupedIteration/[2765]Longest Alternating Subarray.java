package weeklyContest.groupedIteration;

//leetcode submit region begin(Prohibit modification and deletion)
class AlternatingSubarray {
    public int alternatingSubarray(int[] nums) {
        int i = 0;
        int n = nums.length;
        int max = -1;
        while(i<n-1){
            //先确定分组的起点
            if(nums[i+1] - nums[i]!=1){
                i++;
                continue;
            }
            //3,4,3,4,3,4
            //确定分组的终点
            int start = i;
            i+=2;
            while(i<n && nums[i]==nums[i-2]){
                i++;
            }
            max = Math.max(max, i-start);
            i--;

        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
