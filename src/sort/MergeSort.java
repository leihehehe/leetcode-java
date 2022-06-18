package sort;


import java.util.Arrays;

public class MergeSort {
    /***
     * O(nlogn)
     */
    public static int count;
    public static void mergeSort(int l, int r, int[] nums){
        if(l>=r) return;
        int mid = l+(r-l)/2;
        //sort
        mergeSort(l,mid,nums);
        mergeSort(mid+1,r,nums);
        //merge
        int[] temp = new int[r-l+1];
        int k=0, i=l, j=mid+1;
        while(i<=mid && j<=r){
            if(nums[i]<=nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }
        while(i<=mid) temp[k++]=nums[i++];
        while(j<=r) temp[k++]=nums[j++];
        //assign
        for(int a=l,b=0;a<=r;a++,b++){
            nums[a]=temp[b];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,5,2,1,4,5,3};
        merge_Sort(0,a.length-1,a);
        System.out.println(Arrays.toString(a));
        System.out.println(count);
    }

    public static void merge_Sort(int l,int r, int[] nums){
        if(l>=r) return;
        int mid = l+(r-l)/2;
        //partition
        mergeSort(l,mid,nums);
        mergeSort(mid+1,r,nums);
        int[] temp =new int[r-l+1];
        int k=0, i=l, j=mid+1;
        //merge
        while(i<=mid && j<=r){
            if(nums[i]<=nums[j]){
                temp[k++]=nums[i++];
            }
            else {
                temp[k++]=nums[j++];
                count++;
            }
        }
        while(i<=mid){
            temp[k++]=nums[i++];
            if(i>2 && nums[i-1]<nums[i-2])
                count++;
        }
        while(j<=r){
            temp[k++]=nums[j++];
            if(j>2 && nums[j-1]<nums[j-2])
                count++;
        }
        //
        for(int a=l,b=0;a<=r;a++,b++){
            nums[a]=temp[b];
        }

    }
}
