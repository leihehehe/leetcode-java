package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        up[0]=1;
        down[0]=1;
        int res = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                up[i] = down[i-1]+1;
                down[i]=down[i-1];
            } else if (nums[i]==nums[i-1]) {
                up[i]=up[i-1];
                down[i]=down[i-1];
            }else {
                down[i] = up[i-1]+1;
                up[i]=up[i-1];
            }
            res = Math.max(res,Math.max(up[i],down[i]));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
