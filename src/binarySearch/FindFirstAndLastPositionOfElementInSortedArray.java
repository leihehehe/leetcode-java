package binarySearch;

import java.util.Arrays;

/***
 * acwing 789
 * leetcode 34
 */
public class FindFirstAndLastPositionOfElementInSortedArray {


    public static int leftBinarySearch(int target, int[] nums){
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]>=target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        if(nums[r]!=target) return -1;
        return r;
    }
    public static int rightBinarySearch(int target, int[] nums){
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = l+(r-l+1)/2;
            if(nums[mid]<=target){
                l = mid;
            }else{
                r = mid-1;
            }
        }
        return r;
    }

    public static int[] searchRange(int[] nums, int target) {

        if(nums.length==0) return new int[]{-1,-1};
        int l = leftBinarySearch(target,nums);
        if (l!=-1){
            int r = rightBinarySearch(target,nums);
            return new int[] {l,r};
        }
        return new int[]{-1,-1};

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3, 3, 3, 4, 5, 6}, 3)));

        System.out.println(Arrays.toString(searchRangeMethod2(new int[]{1, 2, 3, 3, 3, 4, 5, 6}, 3)));


    }
    public static int[] searchRangeMethod2(int[] nums, int target) {

        if(nums.length==0) return new int[]{-1,-1};
        int l = leftBinarySearchMethod2(nums,target);
        if (l!=-1){
            int r = rightBinarySearchMethod2(nums,target);
            return new int[] {l,r};
        }
        return new int[]{-1,-1};

    }

    /***
     * [l,r]
     * @param nums
     * @param target
     * @return
     */
    public static int leftBinarySearchMethod2(int[] nums, int target){
        int l =0, r = nums.length-1;
        while (l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                // if nums[mid] = target, move the left pointer
                if(mid==0 || nums[mid-1] != target)
                    //validate
                    return mid;
                else
                    r=mid-1;
            }else if(nums[mid] > target){
                r = mid-1;
            }else{
                l= mid+1;
            }
        }
        return -1;
    }

    public static int rightBinarySearchMethod2(int[] nums, int target){
        int l =0, r = nums.length-1;
        while (l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                // if nums[mid] = target, move the right pointer
                if(mid==nums.length-1 || nums[mid+1] != target)
                    //validate
                    return mid;
                else
                    l=mid+1;
            }else if(nums[mid] > target){
                r = mid-1;
            }else{
                l= mid+1;
            }
        }
        return -1;
    }

}
