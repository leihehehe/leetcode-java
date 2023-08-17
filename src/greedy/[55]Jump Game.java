package greedy;

//leetcode submit region begin(Prohibit modification and deletion)
class JumpGame {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for(int i = 0;i<nums.length;i++){
            if(farthest<i){
                return false;
            }
            farthest = Math.max(farthest,nums[i]+i);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
