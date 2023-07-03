package sort;

import java.util.Arrays;

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

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,1,2,6,4};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
}
