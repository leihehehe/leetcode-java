package slidingWindow;

/***
 * leetcode 26
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        //[0,j] contains unique numbers
        if (nums.length<2) return nums.length;
        int j = 0;
        for(int i =0; i<nums.length; i++){
            if(nums[j]!=nums[i]){
                nums[++j]=nums[i];
            }
        }
        return j+1;
    }
    public int removeDuplicatesMethod2(int[] nums) {
        //slow pointer i, fast pointer j
        //loop invariant - [0,j) contains unique numbers
        //which means [0,j-1] is valid array
        int j =1;
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=nums[j-1]){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}
