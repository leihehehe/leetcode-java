package slidingWindow;

/***
 * Leetcode 27
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int j = -1;
        //loop invariant: [0,j] is valid
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=val){
                j++;
                nums[j]=nums[i];
            }

        }
        return j+1;
    }
}
