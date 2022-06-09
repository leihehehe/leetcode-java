package sort;

/***
 * video explanation: https://www.bilibili.com/video/BV1fA4y1o715?vd_source=22b6f0cda021fb400d963c856256ae15
 * Leetcode 704
 */
public class BinarySearch {
    /***
     * interval: left closed, right opened, keep this in mind.
     * @param nums
     * @param target
     * @return
     */
        public int search(int[] nums, int target) {
            int l = 0;
            int r = nums.length;// right is the position that will not be included in the interval
            while(l<r){
                //left cannot equal to right
                int mid = l+(r-l)/2;
                //avoid integer overflow
                if(target>nums[mid]){
                    l=mid+1;
                }else if(target<nums[mid]){
                    r=mid;
                }else{
                    //if target = nums[mid], the mid will be the result
                    return mid;
                }
            }
            return -1;
        }

    /***
     * interval: left closed, right closed, keep this in mind.
     * @param nums
     * @param target
     * @return
     */
    public int searchMethod2(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(target>nums[mid]){
                l=mid+1;
            }else if(target<nums[mid]){
                r=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
