package sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    /**
     * quick sort
     * 0(nlogn)
     * @param l
     * @param r
     * @param a
     */
    static void quicksort(int l,int r,int a[])
    {
        if(l>=r) return;
        // - [l,i] < pivot
        // - [j,r] > pivot
        // two pointers to point to the location where we put the elements
        int i =l-1, j=r+1, x=a[i+j>>1];//get the middle value
        while(i<j){
            //do while
            do i++; while (a[i]<x);
            do j--;  while (a[j]>x);
            if(i<j){
                int temp = a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        quicksort(l,j,a);
        quicksort(j+1,r,a);
    }

    /**
     * Clearer structure
     * @param nums
     * @param l
     * @param r
     */
    public void quickSortSolution2(int[] nums, int l, int r){
        if(l>=r) return;
        int pivotIndex = partition(nums,l,r);
        quickSortSolution2(nums,l,pivotIndex);
        quickSortSolution2(nums,pivotIndex+1,r);
    }

    public int partition(int[] nums, int l, int r){
        //loop invariant: [0,i] < pivot, [j,r] > pivot
        int pivot = nums[l+(r-l)/2], i = l-1, j = r+1;
        while(i<j){
            do i++; while(nums[i]<pivot);
            do j--; while(nums[j]>pivot);
            if(i<j) swap(nums,i,j);
        }
        return j;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,8,4,2,1,3};
        quicksort(0,5,a);
        System.out.println(Arrays.toString(a));
    }
}
