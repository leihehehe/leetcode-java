package random.reservior;

import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class RandomPickIndex {
    int[] nums;
    Random random = new Random();
    public RandomPickIndex(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int res = 0;
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(target==nums[i]){
                count++;
                if(random.nextInt(count)==0){
                    res = i;
                }
            }
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
//leetcode submit region end(Prohibit modification and deletion)
