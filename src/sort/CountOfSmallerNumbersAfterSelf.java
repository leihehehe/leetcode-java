package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 315
 */
public class CountOfSmallerNumbersAfterSelf {
    private int[] temp;
    private int[] res;
    private int[] tempIndex;
    private int[] index;
    public List<Integer> countSmaller(int[] nums) {
        res = new int[nums.length];
        temp = new int[nums.length];
        tempIndex = new int[nums.length];
        index = new int[nums.length];
        for(int i =0; i< nums.length;i++){
            index[i] = i;
        }
        mergeSort(nums,0,nums.length-1);
        List<Integer> arr = new ArrayList<>();
        for(int num:res){
            arr.add(num);
        }
        return arr;
    }
    public void mergeSort(int[] nums, int l, int r){
        if(l>=r) return;
        int mid = l+(r-l)/2;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);
        int i = l, j= mid+1, k = l;
        while(i<=mid && j <=r){
            if(nums[i]<=nums[j]) {
                tempIndex[k] = index[i];
                res[index[i]]+=j-mid-1;
                temp[k++] = nums[i++];
            }else {
                tempIndex[k] = index[j];
                temp[k++] = nums[j++];
            }
        }
        while(i<=mid) {
            tempIndex[k] = index[i];
            res[index[i]]+=j-mid-1;
            temp[k++] = nums[i++];
        }
        while(j<=r){
            tempIndex[k] = index[j];
            temp[k++] = nums[j++];
        }
        for(int a=l;a<=r;a++){
            index[a]=tempIndex[a];
            nums[a]= temp[a];
        }
    }
}
