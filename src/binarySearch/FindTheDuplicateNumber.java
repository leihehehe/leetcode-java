package binarySearch;

/**
 * Leetcode 287
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            int count = 0 ;
            for(int num:nums){
                if(num<=mid) count++;
            }
            if(count>mid){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}
