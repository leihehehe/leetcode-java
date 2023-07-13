package binarySearch;

/***
 * Leetcode 35
 */
class SearchInsertPosition {
    /**
     * Method 1
     * @param nums
     * @param target
     * @return
     */
    public int searchInsertM1(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        //找到
        if(nums[l]==target){
            return l;
        }else if(nums[l]>target){
            //没找到，应该返回比他大的第一个数
            return l;
        }
        return l+1;
    }

    /**
     * Method 2
     * @param nums
     * @param target
     * @return
     */
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
