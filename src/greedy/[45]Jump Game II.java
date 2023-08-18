package greedy;

//leetcode submit region begin(Prohibit modification and deletion)
class JumpGameII {
    public int jump(int[] nums) {
        int end = 0;
        int jump = 0;
        int farthest = 0;
        for(int i = 0;i<nums.length-1;i++){
            farthest = Math.max(farthest,nums[i]+i);
            if(end==i){
                jump++;
                end = farthest;
            }
        }
        return jump;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
