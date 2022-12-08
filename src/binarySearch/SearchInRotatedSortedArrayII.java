package binarySearch;

/**
 * Leetcode 81
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target) return true;
            else if(nums[l]<nums[mid]){
                //[l,mid] sorted
                if(nums[l]<=target && target<nums[mid]) r = mid-1;
                else l = mid+1;
            }else if(nums[l]==nums[mid]){
                l++;
            }else{
                //[mid+1,r] sorted
                if(nums[mid]<target && target<=nums[nums.length-1]) l=mid+1;
                else r=mid-1;
            }
        }
        return false;
    }
}
