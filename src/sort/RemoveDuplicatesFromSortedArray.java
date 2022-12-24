package sort;

/***
 * Leetcode 26
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        //[0,j] no duplicates
        if(nums.length<=1) return nums.length;
        int  j = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }
}
