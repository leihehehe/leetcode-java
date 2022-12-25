package sort;

/**
 * Leetcode 80
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicatesSolution1(int[] nums) {
        if(nums.length<3) return nums.length;
        int j = 1;
        //loop invariant: [0,j] each unique elements appears at most twice
        for(int i = 2; i< nums.length; i++){
            if(nums[i]!=nums[j-1]){
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }
    public int removeDuplicatesSolution2(int[] nums) {
        if(nums.length<3) return nums.length;
        int j = 2;
        //loop invariant: [0,j) each unique elements appears at most twice
        for(int i = 2; i< nums.length; i++){
            if(nums[i]!=nums[j-2]){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
