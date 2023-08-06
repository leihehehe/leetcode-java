package random;

import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Knuth algo
 */
class ShuffleAnArray {
    int[] original;
    int[] nums;
    Random random = new Random();
    public ShuffleAnArray(int[] nums) {
        this.nums = nums.clone();
        this.original = nums.clone();
    }

    public int[] reset() {
        nums = original.clone();
        return nums;
    }

    public int[] shuffle() {
        int n = nums.length;
        for(int i = n-1;i>=0;i--){
            int rIndex = random.nextInt(i+1);
            swap(rIndex,i);
        }
        return nums;
    }
    public void swap(int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)
