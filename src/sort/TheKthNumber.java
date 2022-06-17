package sort;

import java.util.Arrays;

/***
 * acwing 786
 * O(n)
 * quick select => variant of quick sort
 */
public class TheKthNumber {

    public static int quickSelect(int l, int r, int k,int[] nums){
        if(l>=r) return nums[l];
        int i=l-1, j=r+1, p = nums[(l+r)>>1];
        while(i<j){
            do{i++;} while(nums[i]<p);
            do{j--;} while(nums[j]>p);
            if(i<j){
                int temp = nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        if(k<=j){
            return quickSelect(l,j,k,nums);
            //do not need to change k, since i, j, l, r all represent index.
        }
        return quickSelect(j+1,r,k,nums);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,4,2,1};
        int n =nums.length, k = 2;
        // the Kth number means the index is k-1
        System.out.println(quickSelect(0,n-1,k-1,nums));

    }
}
