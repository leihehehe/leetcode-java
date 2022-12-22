package sort;

public class InsertionSort {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for(int i =1; i< len;i++){
            for(int j = i; j>0;j--){
                if(nums[j]<nums[j-1]) swap(nums,j,j-1);
                else break;
            }
        }
        return nums;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
