package slidingWindow;

/***
 * Leetcode 80
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int j =1;
        //loop invariant: [0,j] valid
        for(int i=2;i<nums.length;i++){
            //as we are assigning the value to nums[j+1], we should check nums[j-1]
            if(nums[i]!=nums[j-1]){
                j++;
                nums[j]=nums[i];
            }
        }
        return j+1;
    }
}
