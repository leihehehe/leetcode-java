package sort;

import java.util.Arrays;
import java.util.Random;

public class SortUtil {
    /**
     * Bubble Sort
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            boolean swap = false;
            for(int j = 0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    swap = true;
                }
            }
            if(!swap) break;
        }
        return arr;
    }
    /**
     * Insertion Sort
     * @param arr
     * @return
     */
    public static int[] insertionSort(int[] arr){
        for(int i = 1;i<arr.length;i++){
            int index= i;
            while(index>0 && arr[index]<arr[index-1]){
                swap(arr,index,index-1);
            }
        }
        return arr;
    }

    /**
     * Selection Sort
     * @param arr
     * @return
     */
    public static int[] selectionSort(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            int minIndex = i;
            for(int j =i+1;j<arr.length;j++){
                if(arr[minIndex]>arr[j]){
                    minIndex=j;
                }
            }
            swap(arr,i,minIndex);
        }
        return arr;
    }

    /**
     * Merge Sort
     * @param arr
     * @param l
     * @param r
     */
    public static void mergeSort(int[] arr, int l, int r){
        if(l>=r) return;
        int mid = l+(r-l)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        mergeTwoSortedArray(arr,l,mid,r);
    }

    /**
     * merge two sorted array: arr[0,mid] and arr[mid+1,r]
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    public static void mergeTwoSortedArray(int[] arr, int l, int mid, int r){
        //[l,mid]有序
        //[mid+1,r]有序
        int[] res = new int[r-l+1];
        int p =0, i = l, j = mid+1;
        while(i<=mid && j<=r){
            if(arr[i]<=arr[j]) res[p++] = arr[i++];
            else res[p++] = arr[j++];
        }
        while(i<=mid) res[p++] = arr[i++];
        while(j<=r) res[p++]= arr[j++];
        for(int a =l,b = 0;a<=r;a++,b++){
            arr[a] = res[b];
        }
    }

    public static void quickSort(int[] arr, int l, int r){
        if(l>=r) return;
        //先进行partition
        int pivotIndex= partition(arr,l,r);
        quickSort(arr,l,pivotIndex);
        quickSort(arr,pivotIndex+1,r);
    }
    public static int partition(int[] arr, int l, int r){
        //loop invariant: [0,i]<pivot<[j,r]
        int i =l-1, j = r+1;
        int pivotIndex = l+(r-l)/2;
        int pivot = arr[pivotIndex];
        while(i<j){
            do i++; while (arr[i]<pivot);
            do j--; while(arr[j]>pivot);
            if(i<j){
                swap(arr, i, j);
            }
        }
        return j;
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,1,2,6,4};
//        System.out.println(Arrays.toString(bubbleSort(arr)));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
