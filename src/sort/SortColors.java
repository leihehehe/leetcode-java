package sort;

/**
 * Leetcode 75
 */
public class SortColors {
    public void sortColors(int[] nums) {
        //[0,i]=> only 0s, (i,a) => only 1s [j,nums.length-1] => only 2s
        int i = -1, j = nums.length, a = 0;
        while(a<j){
            if(nums[a]==0) swap(nums,++i,a++);
            else if(nums[a]==1) a++;
            else swap(nums,--j,a);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
