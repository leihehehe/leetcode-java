package weeklyContest.prefix;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Weekly Contest -> Week 383
 * Easy
 */
class AntOnTheBoundary {
    public int returnToBoundaryCount(int[] nums) {
        int sum = 0;
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==0){
                count++;
            }
        }
        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
