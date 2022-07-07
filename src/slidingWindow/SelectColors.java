package slidingWindow;

/***
 * Leetcode 75
 */
public class SelectColors {
    public void sortColors(int[] nums) {
        //partition
        //[0,p1]=>0
        //(p1,p2)=>1 don't need to consider this interval.
        //[p2,nums.length-1]=>2
        int p1=-1, p2=nums.length, i =0;
        while(i<p2){
            if(nums[i]==0){
                p1++;
                swap(nums,i,p1);
                i++;
            }else if(nums[i]==2){
                p2--;
                swap(nums,i,p2);
            }else{
                i++;
            }
        }
    }
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
