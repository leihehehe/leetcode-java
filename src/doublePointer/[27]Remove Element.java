package doublePointer;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = -1;
        //loop invariant: [0,i] no `val` in the array.
        for(int j =0;j<nums.length;j++){
            if(nums[j]!=val){
                int temp = nums[++i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return i+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
