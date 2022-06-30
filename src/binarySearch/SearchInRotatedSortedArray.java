package binarySearch;

/***
 * Leetcode 33
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l =0, r = nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target) return mid;
            if(nums[0]<=nums[mid]){
                //the first part is sorted
                if(nums[mid]>target &&target>=nums[0]) r = mid-1;
                else l = mid+1;
            }
            else if(nums[nums.length-1]>=nums[mid]){
                //the second part is sorted
                if(nums[mid]<target && target<=nums[nums.length-1]) l = mid+1;
                else  r=mid-1;
            }
        }
        return -1;
    }
}
