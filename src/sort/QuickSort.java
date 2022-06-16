package sort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
    /**
     * quick sort
     * @param l
     * @param r
     * @param a
     */
    static void quicksort(int l,int r,int a[])
    {
        if(l>=r) return;
        int i =l-1, j=r+1, x=a[(i+j)>>1];//get the middle value
        while(i<j){
            //do while
            do{
                i++;
            } while (a[i]<x);
            do{
                j--;
            } while (a[j]>x);
            if(i<j){
                int temp = a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        quicksort(l,j,a);
        quicksort(j+1,r,a);
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,8,4,2,4,5};
        quicksort(0,5,a);
        System.out.println(Arrays.toString(a));
    }

}
