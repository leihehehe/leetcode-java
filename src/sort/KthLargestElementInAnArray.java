package sort;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {

        return quickSort(nums,0,nums.length-1,k);

    }
    public int quickSort(int[]nums, int l, int r,int k){
        if(l>=r) return nums[r];
        //[l,i]<=pivot
        //[j,r]>=pivot
        int i = l-1, j=r+1, pivot = nums[i+(j-i)/2];
        while(i<j){
            //decreasing
            do i++; while(nums[i]<pivot);
            do j--; while(nums[j]>pivot);
            if(i<j)
                swap(nums,i,j);
        }
        // if the index of the kth largest number(nums.length - k) is smaller and equals to j, go to the left interval, otherwise go to the right one.
        if (nums.length-k <= j) return quickSort(nums, l, j, k);
        else return quickSort(nums, j + 1, r, k);
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
