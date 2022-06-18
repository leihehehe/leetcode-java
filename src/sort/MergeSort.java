package sort;


import java.util.Arrays;

public class MergeSort {
    /***
     * O(nlogn)
     */
    public static void merge_sort(int l, int r, int[] nums){
        if(l>=r) return;
        int mid = l+(r-l)/2;
        //sort
        merge_sort(l,mid,nums);
        merge_sort(mid+1,r,nums);
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
        merge_sort(0,a.length-1,a);
        System.out.println(Arrays.toString(a));
    }

}
