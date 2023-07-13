package binarySearch;

/**
 * Leetcode 153
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]>nums[r]) l = mid+1;
            else r = mid;
        }
        return nums[l];
    }

    public int findMinMethod2(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]>nums[r]) l = mid+1;
            else if(nums[mid]<nums[r]) r= mid;
                // if nums[mid]==nums[r], mid must be the only number in the current array, just return it.(because there's no duplicates, see Leetcode 154)
            else return nums[mid];
        }
        return nums[l];
    }
}
