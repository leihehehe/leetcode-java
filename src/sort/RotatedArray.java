package sort;

/**
 * Leetcode 189
 */
public class RotatedArray {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void rotateSolution2(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            temp[(i+k)%nums.length] = nums[i];
        }
        for(int i = 0;i<temp.length;i++){
            nums[i] = temp[i];
        }
    }
}
