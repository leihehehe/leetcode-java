package sort;

public class SelectionSort {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for(int i = 0;i<n-1;i++){
            int minIndex = i;
            for(int j = i+1;j<n;j++){
                if(nums[j]<nums[minIndex]) minIndex=j;
            }
            swap(nums,minIndex,i);
        }
        return nums;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
