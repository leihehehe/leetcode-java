package binarySearch;

/**
 * Leetcode 81
 */
class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                return true;
            }else if(nums[mid]==nums[l]){
                l++;
            }else if(nums[mid]>nums[l]){
                //mid在left
                if(target>=nums[l] && target<nums[mid]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }else if(nums[mid]==nums[r]){
                r--;
            }else if(nums[mid]<nums[r]){
                //mid在右侧
                if(target<=nums[r] && target>nums[mid]){
                    l = mid+1;
                }else{
                    r = mid -1;
                }
            }
        }
        return false;
    }
}
