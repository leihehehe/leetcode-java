package binarySearch;

/***
 * Leetcode 35
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(nums[len-1]<target) return len;
        int l=0, r=len-1;
        while(l<r){
            int mid =l+(r-l)/2;
            if(nums[mid]<target) l = mid+1;
            else r=mid;
        }
        return l;
    }
}
